package com.stu.otsea.dao.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.stu.otsea.dao.IMongoClient;
import com.stu.otsea.util.ConfigUtil;
import com.stu.otsea.util.PathUtil;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

@Component("MongoPool")
public class MongoPool implements IMongoClient {
    private MongoClient mongoClient = null;

    private MongoPool() {
        ConfigUtil configUtil = new ConfigUtil(PathUtil.getResourcePath("mongodb.properties"));
        String host = configUtil.getString("mongo.host");
        int port = configUtil.getInt("mongo.port");
        int maxConn = configUtil.getInt("mongo.connect.maxNum");
        int connectTimeout = configUtil.getInt("mongo.connect.timeout");
        int maxWait = configUtil.getInt("mongo.wait.max");
        int waitThread = configUtil.getInt("mongo.wait.num");

        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(maxConn);
        builder.connectTimeout(connectTimeout);
        builder.maxWaitTime(maxWait);
        builder.threadsAllowedToBlockForConnectionMultiplier(waitThread);
        builder.maxConnectionIdleTime(0);
        builder.maxConnectionLifeTime(0);
        builder.socketTimeout(0);
        builder.socketKeepAlive(true);
        MongoClientOptions myOptions = builder.build();
        mongoClient = new com.mongodb.MongoClient(new ServerAddress(host, port), myOptions);
    }


    @Override
    public MongoDatabase getDb(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    @Override
    public MongoCollection<Document> getCollection(String dbName, String collectionName) {
        MongoDatabase db = mongoClient.getDatabase(dbName);
        return db.getCollection(collectionName);
    }

    @Override
    public boolean insert(String dbName, String collectionName, Document doc) {
        MongoCollection<Document> dbCollection = this.getCollection(dbName, collectionName);
        long num = dbCollection.count();
        dbCollection.insertOne(doc);
        return dbCollection.count() - num == 1;
    }

    @Override
    public int delete(String dbName, String collectionName, Bson condition) {
        MongoCollection<Document> dbCollection = this.getCollection(dbName, collectionName);
        DeleteResult deleteResult = dbCollection.deleteOne(condition);
        return (int) deleteResult.getDeletedCount();
    }

    @Override
    public FindIterable<Document> find(String dbName, String collectionName, Bson condition) {
        MongoCollection<Document> dbCollection = this.getCollection(dbName, collectionName);
        return dbCollection.find(condition);
    }

    @Override
    public boolean updateOne(String dbName, String collectionName, Bson condition, Bson value) {
        MongoCollection<Document> dbCollection = this.getCollection(dbName, collectionName);
        UpdateResult updateResult = dbCollection.updateOne(condition, value);
        return updateResult.getMatchedCount() == 1;
    }

    @Override
    public boolean isExit(String dbName, String collectionName, Bson condition) {
        MongoCollection<Document> dbCollection = this.getCollection(dbName, collectionName);
        return dbCollection.count(condition) > 0;
    }
}

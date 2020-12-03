package com.stu.otsea.util.mongoDB;

import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoPool implements MongoClient {
    public static final String IP = "127.0.0.1";
    public static final int PORT = 27017;

    private com.mongodb.MongoClient mongoClient = null;

    private MongoPool() {
        MongoClientOptions.Builder buide = new MongoClientOptions.Builder();
        buide.connectionsPerHost(10);// 与目标数据库可以建立的最大链接数
        buide.connectTimeout(1000 * 60 * 20);// 与数据库建立链接的超时时间
        buide.maxWaitTime(100 * 60 * 5);// 一个线程成功获取到一个可用数据库之前的最大等待时间
        buide.threadsAllowedToBlockForConnectionMultiplier(100);
        buide.maxConnectionIdleTime(0);
        buide.maxConnectionLifeTime(0);
        buide.socketTimeout(0);
        buide.socketKeepAlive(true);
        MongoClientOptions myOptions = buide.build();
        mongoClient = new com.mongodb.MongoClient(new ServerAddress(IP, PORT), myOptions);
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

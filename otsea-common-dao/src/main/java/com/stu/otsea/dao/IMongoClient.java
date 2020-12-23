package com.stu.otsea.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public interface IMongoClient {
    MongoDatabase getDb(String dbName);

    MongoCollection<Document> getCollection(String dbName, String collectionName);

    boolean insert(String dbName, String collectionName, Document doc);

    int delete(String dbName, String collectionName, Bson condition);

    FindIterable<Document> find(String dbName, String collectionName, Bson condition);

    boolean updateOne(String dbName, String collectionName, Bson condition, Bson value);

    boolean isExit(String dbName, String collectionName, Bson condition);

}

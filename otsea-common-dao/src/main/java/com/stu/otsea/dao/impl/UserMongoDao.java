package com.stu.otsea.dao.impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.stu.otsea.dao.IMongoClient;
import com.stu.otsea.ec.entity.User;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserMongoDao {
    public static final String DB_NAME = "otsea";
    public static final String COLLECTION_NAME = "user";

    @Resource(name = "MongoPool")
    private IMongoClient mongoClient;

    public User selectOneByMail(String mail) {
        Bson mailFilter = Filters.eq("mail", mail);
        FindIterable<Document> rs = mongoClient.find(DB_NAME, COLLECTION_NAME, mailFilter);
        MongoCursor<Document> it = rs.iterator();
        if (!it.hasNext()) return null;
        return User.packFromMongoDocument(it.next());
    }

    public User selectOneByName(String name) {
        Bson nameFilter = Filters.eq("name", name);
        FindIterable<Document> rs = mongoClient.find(DB_NAME, COLLECTION_NAME, nameFilter);
        MongoCursor<Document> it = rs.iterator();

        if (!it.hasNext()) return null;
        return User.packFromMongoDocument(it.next());
    }

    public User selectOneById(String id) {
        Bson nameFilter = Filters.eq("_id", new ObjectId(id));
        FindIterable<Document> rs = mongoClient.find(DB_NAME, COLLECTION_NAME, nameFilter);
        MongoCursor<Document> it = rs.iterator();

        if (!it.hasNext()) return null;
        return User.packFromMongoDocument(it.next());
    }

    public boolean insertOne(User user) {
        Document doc = user.toMongoDocument();
        return mongoClient.insert(DB_NAME, COLLECTION_NAME, doc);
    }


}

package com.stu.otsea.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.stu.otsea.ec.entity.User;
import com.stu.otsea.ec.enumreation.UserEnum;
import com.stu.otsea.web.mongoDB.MongoClient;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserMongoDao {
    public static final String DB_NAME = "otsea";
    public static final String COLLECTION_NAME = "user";

    @Resource(name = "MongoPool")
    private MongoClient mongoClient;

    public User selectOneByMail(String mail) throws InstantiationException, IllegalAccessException {
        Bson mailFilter = Filters.eq(UserEnum.MAIL, mail);
        FindIterable<Document> rs = mongoClient.find(DB_NAME, COLLECTION_NAME, mailFilter);
        MongoCursor<Document> it = rs.iterator();
        if (!it.hasNext()) return null;
        return User.packFromMongoDocument(it.next());
    }

    public boolean insertOne(User user) {
        Document doc = user.toMongoDocument();
        return mongoClient.insert(DB_NAME, COLLECTION_NAME, doc);
    }


}

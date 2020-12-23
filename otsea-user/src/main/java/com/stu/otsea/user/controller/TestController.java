package com.stu.otsea.user.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.stu.otsea.dao.IMongoClient;
import com.stu.otsea.web.rest.Rest;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 15:42
 * @Description:
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/otsea/test")
public class TestController {

    //this is for 测试jenkins2的
    @Resource(name = "MongoPool")
    private IMongoClient mongoClient;

    @RequestMapping("mongo")
    public Rest<String> mongoTest() {
        MongoCollection<Document> conn = mongoClient.getCollection("otsea", "user");
        MongoCursor<Document> it = conn.find().iterator();
        while (it.hasNext()) {
            Document doc = it.next();
            for (Map.Entry<String, Object> entry : doc.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            System.out.println();
        }
        return Rest.ok();
    }
}

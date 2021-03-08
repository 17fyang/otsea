package com.stu.otsea.web.config;

import com.alibaba.fastjson.JSONObject;
import com.stu.otsea.ec.component.MongoIdComponent;
import com.stu.otsea.ec.component.handle.HandleFactory;
import com.stu.otsea.ec.entity.User;
import com.stu.otsea.ec.enumreation.CompEnum;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/23 14:38
 * @Description:User类的redis序列化方法
 */
public class UserRedisSerialize implements RedisSerializer<User> {
    public static final Logger logger = LoggerFactory.getLogger(UserRedisSerialize.class);

    @Override
    public byte[] serialize(User user) throws SerializationException {
        if (user == null) return null;
        MongoIdComponent idComponent = HandleFactory.MONGO_ID_HANDLE.bindComponent(user);
        Document doc = user.toMongoDocument();
        doc.append(CompEnum.MONGO_ID, idComponent.get_id());
        return doc.toJson().getBytes();
    }

    @Override
    public User deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null) return null;
        try {
            JSONObject json = (JSONObject) JSONObject.parse(new String(bytes));
            return User.packFromEntrySet(json.entrySet());
        } catch (Exception e) {
            logger.error("fail to deserialize User class with {}", new String(bytes));
            return null;
        }
    }
}

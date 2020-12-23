package com.stu.otsea.web.config;

import com.alibaba.fastjson.JSONObject;
import com.stu.otsea.ec.entity.User;
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
        return user.toMongoDocument().toJson().getBytes();
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

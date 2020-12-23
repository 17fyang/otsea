package com.stu.otsea.web.config;

import com.stu.otsea.ec.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/23 13:41
 * @Description:
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new UserRedisSerialize());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}



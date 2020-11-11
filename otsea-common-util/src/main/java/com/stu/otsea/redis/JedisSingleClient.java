package com.stu.otsea.redis;

import com.stu.otsea.properties.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 单机版redis的实现
 */
public class JedisSingleClient implements JedisClient {
    private static final Logger logger = LoggerFactory.getLogger(JedisSingleClient.class);
    private JedisPool jedisPool;

    public JedisSingleClient() {
        JedisPoolConfig config = RedisProperties.getInstance().getPoolConfig();
        String host = RedisProperties.getInstance().getPoolHost();
        int port = RedisProperties.getInstance().getPoolPort();
        int timeout = RedisProperties.getInstance().getTimeout();
        String password = RedisProperties.getInstance().getPassword();
        jedisPool = new JedisPool(config, host, port, timeout, password);

        logger.info("redis single client init finish !!");
    }

    @Override
    public String get(String key) {
        Jedis resource = jedisPool.getResource();
        String string = resource.get(key);
        resource.close();
        return string;
    }

    @Override
    public String set(String key, String value) {
        Jedis resource = jedisPool.getResource();
        String string = resource.set(key, value);
        resource.close();
        return string;
    }
    
    @Override
    public long expire(String key, Integer second) {
        Jedis resource = jedisPool.getResource();
        Long expire = resource.expire(key, second);
        resource.close();
        return expire;
    }

    @Override
    public long del(String key) {
        Jedis resource = jedisPool.getResource();
        Long del = resource.del(key);
        resource.close();
        return del;
    }
}

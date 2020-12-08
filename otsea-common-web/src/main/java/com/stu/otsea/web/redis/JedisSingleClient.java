package com.stu.otsea.web.redis;

import com.stu.otsea.web.properties.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/11 20:27
 * @Version: 1.0
 * @Description: 单机版redis的实现
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
        jedisPool = new JedisPool(config, host, port);
//        jedisPool = new JedisPool(config, host, port, timeout, password);

        logger.info("redis single client init finish !!");
    }

    @Override
    public String get(String key) {
        return this.safeRun((r) -> r.get(key));
    }

    @Override
    public String set(String key, String value) {
        return this.safeRun((r) -> r.set(key, value));
    }

    @Override
    public long expire(String key, Integer second) {
        return this.safeRun((r) -> r.expire(key, second));
    }

    @Override
    public long del(String key) {
        return this.safeRun((r) -> r.del(key));
    }

    private <T> T safeRun(SingleRun<T> func) {
        Jedis resource = jedisPool.getResource();
        T result = func.run(resource);
        resource.close();
        return result;
    }

    interface SingleRun<T> {
        T run(Jedis resource);
    }
}


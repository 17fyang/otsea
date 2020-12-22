package com.stu.otsea.web.redis;

import com.stu.otsea.web.util.ConfigUtil;
import com.stu.otsea.web.util.PathUtil;
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
public class JedisSingleClient implements IJedisClient {
    private static final Logger logger = LoggerFactory.getLogger(JedisSingleClient.class);
    private JedisPool jedisPool;

    public JedisSingleClient() {
        ConfigUtil configUtil = new ConfigUtil(PathUtil.getResourcePath("redis.properties"));

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(configUtil.getInt("redis.min.idle"));
        config.setMaxIdle(configUtil.getInt("redis.max.idle"));
        String host = configUtil.getString("redis.pool.host");
        int port = configUtil.getInt("redis.pool.port");
        int timeout = configUtil.getInt("redis.timeout");
        String password = configUtil.getString("redis.password");
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


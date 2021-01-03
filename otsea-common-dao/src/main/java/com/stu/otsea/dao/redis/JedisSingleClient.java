package com.stu.otsea.dao.redis;

import com.stu.otsea.util.ConfigUtil;
import com.stu.otsea.util.path.AutoPathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 16:19
 * @Description:
 */
@Deprecated
public class JedisSingleClient implements IJedisClient {
    private static final Logger logger = LoggerFactory.getLogger(JedisSingleClient.class);
    private final JedisPool jedisPool;

    public JedisSingleClient() {
        ConfigUtil configUtil = new ConfigUtil(AutoPathUtil.getInstance().getConfig("redis.properties"));

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
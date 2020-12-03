package com.stu.otsea.web.properties;

import com.stu.otsea.web.path.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/11 20:27
 * @Version: 1.0
 * @Description:
 */
public class RedisProperties {
    private static final String PROPERTIES_LOCATION = PathUtil.getResourcePath("redis.properties");
    private static final Logger logger = LoggerFactory.getLogger(RedisProperties.class);
    private static final RedisProperties redisProperties = new RedisProperties();
    private Properties properties;

    public static RedisProperties getInstance() {
        return redisProperties;
    }

    private RedisProperties() {
        try (InputStream in = new FileInputStream(PROPERTIES_LOCATION)) {
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            logger.error("error!! 加载redis配置文件失败");
            e.printStackTrace();
        }
    }

    public String getRedisCluster() {
        return this.properties.getProperty("redis.cluster");
    }

    public String getPoolHost() {
        return this.properties.getProperty("redis.pool.host");
    }

    public int getPoolPort() {
        return Integer.parseInt(this.properties.getProperty("redis.pool.port"));
    }

    public JedisPoolConfig getPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(this.properties.getProperty("redis.min.idle")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(this.properties.getProperty("redis.max.idle")));
        return jedisPoolConfig;
    }

    public String getPassword() {
        return this.properties.getProperty("redis.password");
    }

    public int getTimeout() {
        return Integer.parseInt(this.properties.getProperty("redis.timeout"));
    }

    public int getMaxAttempts() {
        return Integer.parseInt(this.properties.getProperty("redis.max.attempts"));
    }

    public int getSoTimeout() {
        return Integer.parseInt(this.properties.getProperty("redis.soTimeout"));
    }
}

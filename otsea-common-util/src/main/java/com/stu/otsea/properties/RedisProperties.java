package com.stu.otsea.properties;

import redis.clients.jedis.JedisPoolConfig;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class RedisProperties {
    private static String PROPERTIES_LOCATION = "redis.properties";

    private Properties properties;
    private static RedisProperties redisProperties = new RedisProperties();

    public static RedisProperties getInstance() {
        return redisProperties;
    }

    private RedisProperties() {
        try (InputStream in = new FileInputStream(PROPERTIES_LOCATION)) {
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            System.out.println("error!! 加载redis配置文件失败");
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

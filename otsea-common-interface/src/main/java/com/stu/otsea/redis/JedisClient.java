package com.stu.otsea.redis;

public interface JedisClient {

    String get(String key);

    String set(String key, String value);

    long expire(String key, Integer second);

    long del(String key);
}

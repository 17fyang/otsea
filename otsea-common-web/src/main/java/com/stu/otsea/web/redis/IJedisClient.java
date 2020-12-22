package com.stu.otsea.web.redis;

public interface IJedisClient {

    String get(String key);

    String set(String key, String value);

    long expire(String key, Integer second);

    long del(String key);
}

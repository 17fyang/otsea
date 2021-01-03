package com.stu.otsea.dao.redis;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 16:17
 * @Description:
 */
@Deprecated
public interface IJedisClient {
    String get(String key);

    String set(String key, String value);

    long expire(String key, Integer second);

    long del(String key);
}

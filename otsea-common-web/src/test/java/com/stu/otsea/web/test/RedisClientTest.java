package com.stu.otsea.web.test;

import com.stu.otsea.web.redis.IJedisClient;
import com.stu.otsea.web.redis.JedisSingleClient;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/11 20:27
 * @Version: 1.0
 * @Description: redisClient连接测试
 */
public class RedisClientTest {

    @Test
    public void noTest() {
        System.out.println("no test and pass !!");
    }

    @Ignore
    public void jedisSingleTest() {
        IJedisClient singleClient = new JedisSingleClient();
        String testKey = "testKey";
        String testValue = "testValue";
        singleClient.set(testKey, testValue);
        Assert.assertEquals(singleClient.get(testKey), testValue);
    }


}

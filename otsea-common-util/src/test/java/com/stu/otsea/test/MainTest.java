package com.stu.otsea.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/11 20:27
 * @Version: 1.0
 * @Description: 用来批量运行测试类
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        RedisClientTest.class
})
public class MainTest {

}

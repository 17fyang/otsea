package com.stu.otsea.web.config;

import com.stu.otsea.web.util.ConfigUtil;
import com.stu.otsea.web.util.PathUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/22 23:02
 * @Description:
 */
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private final ConfigUtil configUtil = new ConfigUtil(PathUtil.getResourcePath("redis.properties"));

    private final String host = configUtil.getString("redis.pool.host");
    private final int port = configUtil.getInt("redis.pool.port");
}

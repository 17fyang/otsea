package com.stu.otsea.user;


import com.stu.otsea.web.redis.JedisClient;
import com.stu.otsea.web.redis.JedisSingleClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 14:09
 * @Version: 1.0
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.stu.otsea"})
public class OtseaUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtseaUserServiceApplication.class, args);
    }

    /**
     * 手动声明Jedis bean
     */
    @Bean
    public JedisClient jedisClient() {
        return new JedisSingleClient();
//        return new JedisClusterClient();
    }


}

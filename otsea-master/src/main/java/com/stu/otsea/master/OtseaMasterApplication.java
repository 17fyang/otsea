package com.stu.otsea.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 15:22
 * @Version: 1.0
 * @Description:
 */
@EnableEurekaServer
@SpringBootApplication
public class OtseaMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtseaMasterApplication.class, args);
    }
}

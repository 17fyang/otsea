package com.stu.otsea.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
}
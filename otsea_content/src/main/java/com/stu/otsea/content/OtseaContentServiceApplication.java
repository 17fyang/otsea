package com.stu.otsea.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 17:08
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.stu.otsea.dao")
@ComponentScan(basePackages = "com.stu.otsea")
public class OtseaContentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtseaContentServiceApplication.class, args);
    }
}

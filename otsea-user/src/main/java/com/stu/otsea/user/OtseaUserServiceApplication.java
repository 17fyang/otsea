package com.stu.otsea.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 14:09
 * @Version: 1.0
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.stu.otsea.dao")
@ComponentScan(basePackages = "com.stu.otsea")
public class OtseaUserServiceApplication {
    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(OtseaUserServiceApplication.class, args);
    }

}

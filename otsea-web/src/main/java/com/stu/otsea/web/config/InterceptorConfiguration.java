package com.stu.otsea.web.config;

import com.stu.otsea.web.aop.LogInterceptor;
import com.stu.otsea.web.aop.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/23 21:06
 * @Description: controller 拦截器配置
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册日志拦截器
        InterceptorRegistration logRegistration = registry.addInterceptor(new LogInterceptor());
        logRegistration.addPathPatterns("/otsea/**");

        //注册token拦截器
        InterceptorRegistration tokenRegistration = registry.addInterceptor(new TokenInterceptor());
        tokenRegistration.addPathPatterns("/otsea/**");

    }
}

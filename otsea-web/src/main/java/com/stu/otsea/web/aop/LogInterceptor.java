package com.stu.otsea.web.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 22:16
 * @Description:
 */
public class LogInterceptor implements HandlerInterceptor {
    public static final Logger logger = LoggerFactory.getLogger("http request");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(request.getRequestURL().toString());
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entrySet : map.entrySet()) {
            sb.append(" ").append(Arrays.toString(entrySet.getValue()));
        }

        logger.info(sb.toString());
        return true;
    }
}

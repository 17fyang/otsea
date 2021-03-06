package com.stu.otsea.web.aop;

import com.stu.otsea.util.JwtUtil;
import com.stu.otsea.web.exception.StatusException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/23 21:08
 * @Description: 用户登录的拦截器
 */
public class TokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Token annotation = null;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Token.class);
        }

        if (annotation != null) {
            String token = request.getHeader("token");
            String id = JwtUtil.verifyId(token);
            if (id == null) throw new StatusException("用户未登录");

            IdThreadLocal.INSTANCE.set(id);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        IdThreadLocal.INSTANCE.remove();
    }
}

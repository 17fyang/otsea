package com.stu.otsea.web.exception;

import com.stu.otsea.web.rest.Rest;
import com.stu.otsea.web.rest.RestCode;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 17:14
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = OutputException.class)
    @ResponseBody
    public Rest<String> handleOutputException(HttpServletRequest req, OutputException e) {
        return new Rest<>(e.getRestCode(), e.getMsg(), null);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Rest<String> handleMethodException(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        return new Rest<>(RestCode.METHOD_NO_SUPPORT, null);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Rest<String> handleUnknownException(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        return new Rest<>(RestCode.UNKNOWN, null);
    }


}

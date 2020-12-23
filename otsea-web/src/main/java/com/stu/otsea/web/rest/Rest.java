package com.stu.otsea.web.rest;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 10:01
 * @Version: 1.0
 * @Description: Restful格式返回封装类
 */
public class Rest<T> {
    private RestCode code;
    private String msg;
    private T data;

    public Rest(T data) {
        this.packRest(RestCode.SUCCEED, RestCode.SUCCEED.getDefaultMsg(), data);
    }

    public Rest(RestCode code, T data) {
        this.packRest(code, code.getDefaultMsg(), data);
    }

    public Rest(RestCode code, String msg, T data) {
        this.packRest(code, msg, data);
    }

    public static Rest<String> ok() {
        return new Rest<>(RestCode.SUCCEED, "");
    }

    private void packRest(RestCode code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestCode getCode() {
        return code;
    }

    public void setCode(RestCode code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
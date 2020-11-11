package com.stu.otsea.web;

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
package com.stu.otsea.web.exception;

import com.stu.otsea.web.rest.RestCode;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 16:50
 * @Description:
 */
public class OutputException extends RuntimeException {
    private RestCode code;
    private String msg;

    public OutputException(RestCode restCode) {
        this.code = restCode;
    }

    public OutputException(RestCode restCode, String msg) {
        this.code = restCode;
        this.msg = msg;
    }

    public RestCode getRestCode() {
        return this.code;
    }

    public String getMsg() {
        if (msg == null || msg.equals("")) return code.getDefaultMsg();
        return msg;
    }
}

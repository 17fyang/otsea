package com.stu.otsea.util.web;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 10:02
 * @Version: 1.0
 * @Description: restful状态码
 */
public enum RestCode {
    SUCCEED(200, "请求成功");

    private final int code;
    private final String defaultMsg;

    RestCode(int code, String defaultMsg) {
        this.code = code;
        this.defaultMsg = defaultMsg;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }
}

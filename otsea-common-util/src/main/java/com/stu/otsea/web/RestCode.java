package com.stu.otsea.web;

import com.fasterxml.jackson.annotation.JsonValue;

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

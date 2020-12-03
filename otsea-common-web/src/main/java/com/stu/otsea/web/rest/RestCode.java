package com.stu.otsea.web.rest;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 10:02
 * @Version: 1.0
 * @Description: restful状态码
 */
public enum RestCode {
    SUCCEED(200, "请求成功"),
    UNKNOWN(500, "未知错误"),
    DATA_FORMAT_EXCEPTION(511, "数据格式不符合规范！"),
    DATA_CONTENT_EXCEPTION(510, "数据内容有误！");


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

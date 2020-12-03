package com.stu.otsea.web.exception;

import com.stu.otsea.web.rest.RestCode;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 16:48
 * @Description:
 */
public class DataContentException extends OutputException {
    public DataContentException(String msg) {
        super(RestCode.DATA_CONTENT_EXCEPTION, msg);
    }
}

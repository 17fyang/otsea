package com.stu.otsea.web.exception;

import com.stu.otsea.web.rest.RestCode;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 16:49
 * @Description:
 */
public class DataFormatException extends OutputException {
    public DataFormatException(String msg) {
        super(RestCode.DATA_FORMAT_EXCEPTION, msg);
    }
}

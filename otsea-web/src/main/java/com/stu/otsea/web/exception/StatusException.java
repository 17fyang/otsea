package com.stu.otsea.web.exception;

import com.stu.otsea.web.rest.RestCode;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/8 16:55
 * @Description:
 */
public class StatusException extends OutputException {

    public StatusException(String msg) {
        super(RestCode.STATUS_EXCEPTION, msg);
    }
}

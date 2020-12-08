package com.stu.otsea.web.exception;

import com.stu.otsea.web.rest.RestCode;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/8 14:27
 * @Description:
 */
public class HintException extends OutputException {

    public HintException(String msg) {
        super(RestCode.HINT, msg);
    }
}

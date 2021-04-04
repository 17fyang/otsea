package com.stu.otsea.web.aop;

import com.stu.otsea.web.exception.StatusException;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/3/20 17:06
 * @Description:
 */
public class IdThreadLocal extends ThreadLocal<String> {
    public static final IdThreadLocal INSTANCE = new IdThreadLocal();

    @Override
    public String get() throws StatusException {
        String id = super.get();
        if (id == null) throw new StatusException("用户未登录");
        return id;
    }
}

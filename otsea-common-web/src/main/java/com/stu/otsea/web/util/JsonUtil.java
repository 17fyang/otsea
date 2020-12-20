package com.stu.otsea.web.util;

import com.alibaba.fastjson.JSON;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/20 19:12
 * @Description:
 */
public class JsonUtil {
    /**
     * 安全的把一个字符串转成json对象，如果字符串不符合格式则返回空
     *
     * @param str
     * @return
     */
    public static JSON safeParse(String str) {
        if (str == null || "".equals(str)) return null;
        try {
            return (JSON) JSON.parse(str);
        } catch (Exception e) {
            return null;
        }
    }
}

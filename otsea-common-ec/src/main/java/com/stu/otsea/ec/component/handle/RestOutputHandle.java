package com.stu.otsea.ec.component.handle;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stu.otsea.ec.component.abstractComp.Component;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/7 21:26
 * @Description:
 */
public class RestOutputHandle {
    private Component[] components;

    RestOutputHandle(Component[] components) {
        this.components = components;
    }

    public static RestOutputHandle pack(Component... components) {
        return new RestOutputHandle(components);
    }

    @JsonValue
    public String toJSONObject() {
        JSONObject json = new JSONObject();
        for (Component component : components) {
            String key = ComponentRegister.getKey(component.getClass());
            json.put(key, component.toString());
        }
        return json.toJSONString();
    }
}

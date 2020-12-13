package com.stu.otsea.ec.component.handle;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stu.otsea.ec.component.abstractComp.OutputComponent;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/7 21:26
 * @Description:
 */
public class RestOutputHandle {
    private OutputComponent[] components;

    RestOutputHandle(OutputComponent[] components) {
        this.components = components;
    }

    public static RestOutputHandle pack(OutputComponent... components) {
        return new RestOutputHandle(components);
    }

    @JsonValue
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        for (OutputComponent component : components) {
            String key = ComponentRegister.getKey(component.getClass());
            System.out.println(key);
            json.put(key, component.toString());
        }
        return json;
    }
}

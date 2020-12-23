package com.stu.otsea.ec.component.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stu.otsea.ec.component.abstractComp.Component;
import com.stu.otsea.util.JsonUtil;

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
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        for (Component component : components) {
            String key = ComponentRegister.getKey(component.getClass());

            JSON compJson = JsonUtil.safeParse(component.toString());
            if (compJson == null) json.put(key, component.toString());
            else json.put(key, compJson);
        }
        return json;
    }
}

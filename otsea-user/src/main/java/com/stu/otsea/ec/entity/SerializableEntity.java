package com.stu.otsea.ec.entity;

import com.alibaba.fastjson.JSONObject;
import com.stu.otsea.ec.component.Component;
import com.stu.otsea.ec.component.ComponentRegister;
import com.stu.otsea.ec.serialize.Serializable;

import java.util.Map;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/16 19:20
 * @Version: 1.0
 * @Description:
 */
@SuppressWarnings("all")
public class SerializableEntity extends Entity implements Serializable<SerializableEntity> {
    public static final String ID_KEY = "id";

    @Override
    public void stringToObj(String s) throws IllegalAccessException, InstantiationException {
        JSONObject json = JSONObject.parseObject(s);

        for (Map.Entry<String, Object> entry : json.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();

            if (key.equals(ID_KEY)) {
                this.setId(json.getInteger(ID_KEY));
            } else {
                Class<? extends Component> compClass = ComponentRegister.getComp(value);
                if (compClass != null) {
                    Component comp = compClass.newInstance();
                    Serializable<Component> serializableComp = (Serializable) comp;
                    serializableComp.stringToObj(value);
                    this.getComponentMap().put(compClass, comp);
                }
            }
        }
    }

    @Override
    public String objToString() {
        JSONObject json = new JSONObject();
        json.put(ID_KEY, this.getId());

        Map<Class<? extends Component>, Component> componentMap = this.getComponentMap();
        if (componentMap == null || componentMap.isEmpty()) return json.toJSONString();

        for (Map.Entry<Class<? extends Component>, Component> entry : componentMap.entrySet()) {
            Component comp = entry.getValue();
            if (comp instanceof Serializable) {
                Serializable serializableComp = (Serializable) comp;
                String key = ComponentRegister.getKey(entry.getKey());
                json.put(key, serializableComp.objToString());
            }
        }
        return json.toJSONString();
    }
}

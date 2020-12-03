package com.stu.otsea.ec.entity;

import com.stu.otsea.ec.component.abstractComp.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/16 19:20
 * @Version: 1.0
 * @Description:
 */
public class Entity {
    private Map<Class<? extends Component>, Component> componentMap = new ConcurrentHashMap<>();

    public Map<Class<? extends Component>, Component> getComponentMap() {
        return componentMap;
    }

}

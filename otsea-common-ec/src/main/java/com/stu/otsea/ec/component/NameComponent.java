package com.stu.otsea.ec.component;

import com.stu.otsea.ec.common.InitializeComp;
import com.stu.otsea.ec.component.abstractComp.StringSerializableComp;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/3/17 16:29
 * @Description:
 */
public class NameComponent extends StringSerializableComp implements InitializeComp {
    private String name;

    @Override
    public String objToString() {
        return name;
    }

    @Override
    public void stringToObj(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void initComp() {
        this.name = "新用户";
    }
}

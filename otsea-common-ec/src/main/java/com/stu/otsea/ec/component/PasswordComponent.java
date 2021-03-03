package com.stu.otsea.ec.component;

import com.stu.otsea.ec.component.abstractComp.StringSerializableComp;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 15:25
 * @Description:
 * @since JDK 1.8
 */
public class PasswordComponent extends StringSerializableComp {
    private String password;

    @Override
    public void stringToObj(String s) {
        this.password = s;
    }

    @Override
    public String objToString() {
        return this.password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

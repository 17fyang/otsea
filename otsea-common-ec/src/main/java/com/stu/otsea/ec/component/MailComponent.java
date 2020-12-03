package com.stu.otsea.ec.component;

import com.stu.otsea.ec.component.abstractComp.OutputComponent;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 16:26
 * @Description:
 */
public class MailComponent extends OutputComponent {
    private String mail;

    @Override
    public void stringToObj(String s) {
        this.mail = s;
    }

    @Override
    public String objToString() {
        return this.mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

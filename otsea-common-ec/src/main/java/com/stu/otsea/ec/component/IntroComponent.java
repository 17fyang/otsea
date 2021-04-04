package com.stu.otsea.ec.component;

import com.stu.otsea.ec.common.InitializeComp;
import com.stu.otsea.ec.component.abstractComp.StringSerializableComp;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/3/17 16:29
 * @Description:
 */
public class IntroComponent extends StringSerializableComp implements InitializeComp {
    private String intro;

    @Override
    public String objToString() {
        return intro;
    }

    @Override
    public void stringToObj(String s) {
        this.intro = s;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public void initComp() {
        this.intro = "该用户太懒，没有设置签名";
    }
}

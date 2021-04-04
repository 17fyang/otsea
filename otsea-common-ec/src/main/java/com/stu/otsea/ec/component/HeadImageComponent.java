package com.stu.otsea.ec.component;

import com.stu.otsea.ec.common.InitializeComp;
import com.stu.otsea.ec.component.abstractComp.StringSerializableComp;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/3/17 16:30
 * @Description:
 */
public class HeadImageComponent extends StringSerializableComp implements InitializeComp {
    private String headImage;

    @Override
    public String objToString() {
        return headImage;
    }

    @Override
    public void stringToObj(String s) {
        this.headImage = s;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    @Override
    public void initComp() {
        this.headImage = "/head/defaultHeadImage.png";
    }
}

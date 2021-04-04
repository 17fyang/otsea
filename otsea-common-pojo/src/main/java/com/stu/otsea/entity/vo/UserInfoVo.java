package com.stu.otsea.entity.vo;

import com.stu.otsea.ec.component.HeadImageComponent;
import com.stu.otsea.ec.component.IntroComponent;
import com.stu.otsea.ec.component.MongoIdComponent;
import com.stu.otsea.ec.component.NameComponent;

import java.io.Serializable;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/4 17:57
 * @Description:
 */
public class UserInfoVo implements Serializable {

    private MongoIdComponent userId;
    private NameComponent name;
    private IntroComponent intro;
    private HeadImageComponent headImage;

    public UserInfoVo(MongoIdComponent userId, NameComponent name, IntroComponent intro, HeadImageComponent headImage) {
        this.userId = userId;
        this.name = name;
        this.intro = intro;
        this.headImage = headImage;
    }

    public MongoIdComponent getUserId() {
        return userId;
    }

    public void setUserId(MongoIdComponent userId) {
        this.userId = userId;
    }

    public NameComponent getName() {
        return name;
    }

    public void setName(NameComponent name) {
        this.name = name;
    }

    public IntroComponent getIntro() {
        return intro;
    }

    public void setIntro(IntroComponent intro) {
        this.intro = intro;
    }

    public HeadImageComponent getHeadImage() {
        return headImage;
    }

    public void setHeadImage(HeadImageComponent headImage) {
        this.headImage = headImage;
    }
}

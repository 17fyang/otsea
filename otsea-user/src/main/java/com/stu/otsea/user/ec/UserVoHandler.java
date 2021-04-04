package com.stu.otsea.user.ec;

import com.stu.otsea.ec.component.HeadImageComponent;
import com.stu.otsea.ec.component.IntroComponent;
import com.stu.otsea.ec.component.MongoIdComponent;
import com.stu.otsea.ec.component.NameComponent;
import com.stu.otsea.ec.component.handle.HandleFactory;
import com.stu.otsea.ec.entity.User;
import com.stu.otsea.entity.vo.UserInfoVo;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/2/28 23:20
 * @Description:
 */
public class UserVoHandler {
    private User user;

    public UserVoHandler(User user) {
        if (user == null) throw new RuntimeException("userVoHandler can not receive a empty user!");
        this.user = user;
    }

    /**
     * 生成一个用户的简介信息
     *
     * @return
     */
    public UserInfoVo toIntroduce() {
        MongoIdComponent idComponent = HandleFactory.MONGO_ID_HANDLE.bindComponent(user);
        NameComponent nameComponent = HandleFactory.NAME_HANDLE.bindComponent(user);
        IntroComponent introComponent = HandleFactory.INTRO_HANDLE.bindComponent(user);
        HeadImageComponent headImageComponent = HandleFactory.HEAD_IMAGE.bindComponent(user);
        return new UserInfoVo(idComponent, nameComponent, introComponent, headImageComponent);
    }

}

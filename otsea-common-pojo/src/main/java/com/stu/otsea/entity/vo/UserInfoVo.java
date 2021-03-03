package com.stu.otsea.entity.vo;

import com.stu.otsea.ec.component.MongoIdComponent;
import com.stu.otsea.ec.component.UserComponent;

import java.io.Serializable;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/4 17:57
 * @Description:
 */
public class UserInfoVo implements Serializable {

    private MongoIdComponent userId;
    private UserComponent userInfo;

    public UserInfoVo(MongoIdComponent userId, UserComponent userInfo) {
        this.userId = userId;
        this.userInfo = userInfo;
    }

    public MongoIdComponent getUserId() {
        return userId;
    }

    public void setUserId(MongoIdComponent userId) {
        this.userId = userId;
    }

    public UserComponent getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserComponent userInfo) {
        this.userInfo = userInfo;
    }
}

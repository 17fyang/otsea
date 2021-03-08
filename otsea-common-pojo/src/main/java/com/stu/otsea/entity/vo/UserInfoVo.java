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
    private UserComponent userBaseInfo;

    public UserInfoVo(MongoIdComponent userId, UserComponent userBaseInfo) {
        this.userId = userId;
        this.userBaseInfo = userBaseInfo;
    }

    @Override
    public String toString() {
        return "UserInfoVo{" +
                "userId=" + userId +
                ", userBaseInfo=" + userBaseInfo +
                '}';
    }

    public MongoIdComponent getUserId() {
        return userId;
    }

    public void setUserId(MongoIdComponent userId) {
        this.userId = userId;
    }

    public UserComponent getUserBaseInfo() {
        return userBaseInfo;
    }

    public void setUserBaseInfo(UserComponent userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }
}

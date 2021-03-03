package com.stu.otsea.entity.vo;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 22:47
 * @Description:
 */
public class LoginPassVo {
    private String token;
    private UserInfoVo userInfoVo;

    public LoginPassVo(String token, UserInfoVo userInfoVo) {
        this.token = token;
        this.userInfoVo = userInfoVo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoVo getUserInfoVo() {
        return userInfoVo;
    }

    public void setUserInfoVo(UserInfoVo userInfoVo) {
        this.userInfoVo = userInfoVo;
    }
}

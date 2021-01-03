package com.stu.otsea.entity.vo;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/2 22:47
 * @Description:
 */
public class LoginPassVo {
    private String token;
    private Object restOutputHandle;

    public LoginPassVo(String token, Object restOutputHandle) {
        this.token = token;
        this.restOutputHandle = restOutputHandle;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getRestOutputHandle() {
        return restOutputHandle;
    }

    public void setRestOutputHandle(Object restOutputHandle) {
        this.restOutputHandle = restOutputHandle;
    }
}

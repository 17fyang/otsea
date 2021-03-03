package com.stu.otsea.api.service;

import com.stu.otsea.entity.vo.UserInfoVo;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/4 18:15
 * @Description:
 */
public interface IUserService {

    /**
     * 根据用户id获取用户的展示信息，即不包括敏感信息
     *
     * @param userId
     * @return
     */
    UserInfoVo getUserInfoVoById(String userId);
}

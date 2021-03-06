package com.stu.otsea.user.controller;

import com.stu.otsea.entity.vo.LoginPassVo;
import com.stu.otsea.user.service.UserService;
import com.stu.otsea.web.rest.Rest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 14:15
 * @Version: 1.0
 * @Description:
 */
@Api(value = "用户信息管理")
@RestController
@RequestMapping(value = "/otsea/user", method = {RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录接口")
    @RequestMapping("/login")
    public Rest<LoginPassVo> login(String mail, String password) {
        return userService.login(mail, password);
    }

    @ApiOperation(value = "注册接口")
    @RequestMapping("/register")
    public Rest<String> register(String mail, String password, String verificationCode) {
        return userService.register(mail, password, verificationCode);
    }

    @ApiOperation(value = "获取验证码接口")
    @RequestMapping("/verification")
    public Rest<String> verification(String mail) {
        return userService.verification(mail);
    }

    @RequestMapping("/insertUser")
    public Rest<String> insertUser(String name, String intro, String imageUrl) {
        return new Rest<>(userService.insertUser(name, intro, imageUrl));
    }
}

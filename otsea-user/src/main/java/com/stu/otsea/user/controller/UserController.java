package com.stu.otsea.user.controller;

import com.stu.otsea.ec.component.UserComponent;
import com.stu.otsea.user.service.UserService;
import com.stu.otsea.web.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 14:15
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/otsea/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Rest<UserComponent> login(String mail, String password) throws InstantiationException, IllegalAccessException {
        return userService.login(mail, password);
    }

    @RequestMapping("/register")
    public Rest<String> register(String mail, String password) throws IllegalAccessException, InstantiationException {
        return userService.register(mail, password);
    }

}

package com.stu.otsea.util.user.controller;

import com.stu.otsea.util.web.Rest;
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
    @RequestMapping("/login")
    public Rest<String> login() {
        return Rest.ok();
    }
}

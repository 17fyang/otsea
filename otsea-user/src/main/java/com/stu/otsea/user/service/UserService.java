package com.stu.otsea.user.service;

import com.stu.otsea.dao.UserMongoDao;
import com.stu.otsea.ec.component.MailComponent;
import com.stu.otsea.ec.component.MongoIdComponent;
import com.stu.otsea.ec.component.PasswordComponent;
import com.stu.otsea.ec.component.UserComponent;
import com.stu.otsea.ec.component.handle.HandleEnum;
import com.stu.otsea.ec.entity.User;
import com.stu.otsea.web.exception.DataContentException;
import com.stu.otsea.web.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 14:14
 * @Version: 1.0
 * @Description:
 */
@Component
public class UserService {
    private final Map<String, User> idMap = new ConcurrentHashMap<>();

    @Autowired
    private UserMongoDao userMongoDao;

    public Rest<UserComponent> login(String mail, String password) throws IllegalAccessException, InstantiationException {
        User user = userMongoDao.selectOneByMail(mail);
        if (user == null) throw new DataContentException("找不到该用户！");

        PasswordComponent passwordComponent = HandleEnum.PASSWORD_HANDLE.bindComponent(user);
        if (passwordComponent == null || !passwordComponent.getPassword().equals(password))
            throw new DataContentException("密码错误，请重新输入！");

        MongoIdComponent idComponent = HandleEnum.MONGO_ID_HANDLE.bindComponent(user);
        this.idMap.put(idComponent.get_id(), user);

        UserComponent userComp = HandleEnum.USER_HANDLE.bindComponent(user);
        return new Rest<>(userComp);
    }

    public Rest<String> register(String mail, String password) throws InstantiationException, IllegalAccessException {
        User user = new User();

        MailComponent mailComp = HandleEnum.MAIL_HANDLE.bindComponent(user);
        mailComp.setMail(mail);

        UserComponent userComp = HandleEnum.USER_HANDLE.bindComponent(user);
        userComp.initComp();

        PasswordComponent passwordComp = HandleEnum.PASSWORD_HANDLE.bindComponent(user);
        passwordComp.setPassword(password);

        userMongoDao.insertOne(user);
        return Rest.ok();
    }

    public User getUserCacheById(String id) {
        return this.idMap.get(id);
    }

}

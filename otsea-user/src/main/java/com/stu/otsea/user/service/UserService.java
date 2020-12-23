package com.stu.otsea.user.service;

import com.stu.otsea.dao.impl.UserMongoDao;
import com.stu.otsea.ec.component.MailComponent;
import com.stu.otsea.ec.component.MongoIdComponent;
import com.stu.otsea.ec.component.PasswordComponent;
import com.stu.otsea.ec.component.UserComponent;
import com.stu.otsea.ec.component.handle.HandleEnum;
import com.stu.otsea.ec.component.handle.RestOutputHandle;
import com.stu.otsea.ec.entity.User;
import com.stu.otsea.web.exception.DataContentException;
import com.stu.otsea.web.exception.HintException;
import com.stu.otsea.web.exception.StatusException;
import com.stu.otsea.web.rest.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
    @Autowired
    private UserMongoDao userMongoDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;


    public static final String VERIFICATION_REDIS_KEY = "verify:%s";
    private final Map<String, User> idMap = new ConcurrentHashMap<>();

    public Rest<RestOutputHandle> login(String mail, String password) throws IllegalAccessException, InstantiationException {
        User user = userMongoDao.selectOneByMail(mail);
        if (user == null) throw new DataContentException("找不到该用户！");

        PasswordComponent passwordComponent = HandleEnum.PASSWORD_HANDLE.bindComponent(user);
        if (passwordComponent == null || !passwordComponent.getPassword().equals(password))
            throw new DataContentException("密码错误，请重新输入！");

        MongoIdComponent idComponent = HandleEnum.MONGO_ID_HANDLE.bindComponent(user);
        this.idMap.put(idComponent.get_id(), user);

        UserComponent userComp = HandleEnum.USER_HANDLE.bindComponent(user);
        return new Rest<>(RestOutputHandle.pack(idComponent, userComp));
    }

    public Rest<String> register(String mail, String password, String verificationCode) throws InstantiationException, IllegalAccessException {
        String serverCode = redisTemplate.opsForValue().get(String.format(VERIFICATION_REDIS_KEY, mail));
        if (StringUtils.isEmpty(serverCode)) throw new StatusException("验证码已过期");
        if (!serverCode.equals(verificationCode)) throw new DataContentException("验证码不正确");

        User user = userMongoDao.selectOneByMail(mail);
        if (user != null) throw new StatusException("该用户已存在！");

        user = new User();
        MailComponent mailComp = HandleEnum.MAIL_HANDLE.bindComponent(user);
        mailComp.setMail(mail);
        UserComponent userComp = HandleEnum.USER_HANDLE.bindComponent(user);
        userComp.initComp();
        PasswordComponent passwordComp = HandleEnum.PASSWORD_HANDLE.bindComponent(user);
        passwordComp.setPassword(password);
        userMongoDao.insertOne(user);

        return Rest.ok();
    }

    public Rest<String> verification(String mail) {
        String redisKey = String.format(VERIFICATION_REDIS_KEY, mail);
        String oldCode = redisTemplate.opsForValue().get(redisKey);
        if (!StringUtils.isEmpty(oldCode)) throw new HintException("验证码尚在有效期内");

        String verificationCode = String.valueOf((int) (Math.random() * 900000) + 100000);
        //todo 发邮件，redis设置有效期
        System.out.println("验证码：" + verificationCode);

        redisTemplate.opsForValue().set(redisKey, verificationCode);
        return Rest.ok();
    }

    public User getUserCacheById(String id) {
        return this.idMap.get(id);
    }
}

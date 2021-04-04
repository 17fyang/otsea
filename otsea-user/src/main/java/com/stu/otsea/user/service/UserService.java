package com.stu.otsea.user.service;

import com.stu.otsea.api.service.IUserService;
import com.stu.otsea.dao.impl.UserMongoDao;
import com.stu.otsea.ec.component.*;
import com.stu.otsea.ec.component.handle.HandleFactory;
import com.stu.otsea.ec.entity.User;
import com.stu.otsea.entity.vo.LoginPassVo;
import com.stu.otsea.entity.vo.UserInfoVo;
import com.stu.otsea.user.ec.UserVoHandler;
import com.stu.otsea.util.JwtUtil;
import com.stu.otsea.web.exception.DataContentException;
import com.stu.otsea.web.exception.HintException;
import com.stu.otsea.web.exception.StatusException;
import com.stu.otsea.web.rest.Rest;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 14:14
 * @Version: 1.0
 * @Description:
 */
@Component

@Service(interfaceClass = IUserService.class)
public class UserService implements IUserService {
    public static final int USER_KEY_EXPIRE = 3;
    @Autowired
    private UserMongoDao userMongoDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    public static final String VERIFICATION_REDIS_KEY = "verify:%s";

    /**
     * 登录请求
     *
     * @param mail
     * @param password
     * @return
     */
    public Rest<LoginPassVo> login(String mail, String password) {
        User user = userMongoDao.selectOneByMail(mail);
        if (user == null) throw new DataContentException("找不到该用户！");

        PasswordComponent passwordComponent = HandleFactory.PASSWORD_HANDLE.bindComponent(user);
        if (passwordComponent == null || !passwordComponent.getPassword().equals(password))
            throw new DataContentException("密码错误，请重新输入！");

        //设置对象redis缓存
        MongoIdComponent idComponent = HandleFactory.MONGO_ID_HANDLE.bindComponent(user);
        this.userRedisTemplate.opsForValue().set(idComponent.get_id(), user, USER_KEY_EXPIRE, TimeUnit.HOURS);

        //签发token
        String token = JwtUtil.signById(idComponent.get_id());

        UserVoHandler voHandler = new UserVoHandler(user);
        LoginPassVo loginPassVo = new LoginPassVo(token, voHandler.toIntroduce());
        return new Rest<>(loginPassVo);
    }

    /**
     * 注册请求
     *
     * @param mail
     * @param password
     * @param verificationCode
     * @return
     */
    public Rest<String> register(String mail, String password, String verificationCode) {
        String serverCode = redisTemplate.opsForValue().get(String.format(VERIFICATION_REDIS_KEY, mail));
        if (StringUtils.isEmpty(serverCode)) throw new StatusException("验证码已过期");
        if (!serverCode.equals(verificationCode)) throw new DataContentException("验证码不正确");

        User user = userMongoDao.selectOneByMail(mail);
        if (user != null) throw new StatusException("该用户已存在！");

        user = new User();
        MailComponent mailComp = HandleFactory.MAIL_HANDLE.bindComponent(user);
        mailComp.setMail(mail);

        PasswordComponent passwordComp = HandleFactory.PASSWORD_HANDLE.bindComponent(user);
        passwordComp.setPassword(password);
        userMongoDao.insertOne(user);

        return Rest.ok();
    }

    /**
     * 获取验证码请求
     *
     * @param mail
     * @return
     */
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

    /**
     * 根据用户id获取用户的展示信息，即不包括敏感信息
     *
     * @param userId
     * @return
     */
    public UserInfoVo getUserInfoVoById(String userId) {
        User user = userRedisTemplate.opsForValue().get(userId);

        if (user == null) {
            user = userMongoDao.selectOneById(userId);

            if (user == null) return null;

            MongoIdComponent idComponent = HandleFactory.MONGO_ID_HANDLE.bindComponent(user);
            userRedisTemplate.opsForValue().set(idComponent.get_id(), user, USER_KEY_EXPIRE, TimeUnit.HOURS);
        }

        return getUserInfoVoByUser(user);

    }

    /**
     * 根据User对象返回用户的展示信息
     *
     * @param user
     * @return
     */
    public UserInfoVo getUserInfoVoByUser(User user) {
        if (user == null) return null;

        return new UserVoHandler(user).toIntroduce();
    }

    /**
     * 插入一个用户数据，返回主键
     * 用于爬虫程序
     *
     * @param name
     * @param intro
     * @param imageUrl
     * @return
     */
    public String insertUser(String name, String intro, String imageUrl) {
        User exitUser = userMongoDao.selectOneByName(name);
        if (exitUser != null) {
            MongoIdComponent idComponent = HandleFactory.MONGO_ID_HANDLE.bindComponent(exitUser);
            return idComponent.get_id();
        }

        String mail = UUID.randomUUID().toString() + "@stu.edu.cn";
        String password = "123456";

        User user = new User();
        MailComponent mailComp = HandleFactory.MAIL_HANDLE.bindComponent(user);
        mailComp.setMail(mail);

        NameComponent nameComponent = HandleFactory.NAME_HANDLE.bindComponent(user);
        nameComponent.setName(name);

        IntroComponent introComponent = HandleFactory.INTRO_HANDLE.bindComponent(user);
        introComponent.setIntro(intro);

        HeadImageComponent headImageComponent = HandleFactory.HEAD_IMAGE.bindComponent(user);
        headImageComponent.setHeadImage(imageUrl);

        PasswordComponent passwordComp = HandleFactory.PASSWORD_HANDLE.bindComponent(user);
        passwordComp.setPassword(password);

        userMongoDao.insertOne(user);

        User newUser = userMongoDao.selectOneByMail(mail);
        MongoIdComponent idComponent = HandleFactory.MONGO_ID_HANDLE.bindComponent(newUser);
        return idComponent.get_id();
    }
}

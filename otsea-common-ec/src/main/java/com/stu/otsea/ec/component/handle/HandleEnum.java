package com.stu.otsea.ec.component.handle;

import com.stu.otsea.ec.component.MailComponent;
import com.stu.otsea.ec.component.MongoIdComponent;
import com.stu.otsea.ec.component.PasswordComponent;
import com.stu.otsea.ec.component.UserComponent;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 15:04
 * @Description: component handle 的静态类，可以方便获取到每个component的handle
 * 建议新增完一个component之后在这里写一个handle静态类
 * @since JDK 1.8
 */
public class HandleEnum {
    public static final ComponentHandle<UserComponent> USER_HANDLE = ComponentHandle.buildHandle(UserComponent.class);
    public static final ComponentHandle<PasswordComponent> PASSWORD_HANDLE = ComponentHandle.buildHandle(PasswordComponent.class);
    public static final ComponentHandle<MongoIdComponent> MONGO_ID_HANDLE = ComponentHandle.buildHandle(MongoIdComponent.class);
    public static final ComponentHandle<MailComponent> MAIL_HANDLE = ComponentHandle.buildHandle(MailComponent.class);

}

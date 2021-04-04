package com.stu.otsea.ec.component.handle;

import com.stu.otsea.ec.component.*;
import com.stu.otsea.ec.component.abstractComp.Component;
import com.stu.otsea.ec.enumreation.CompEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/16 20:52
 * @Version: 1.0
 * @Description: component统一注册的地方，新增完一个component之后要在这里注册才能使用
 */
public class ComponentRegister {

    private static final Map<Class<? extends Component>, String> COMP_KEY_MAP = new HashMap<>();
    private static final Map<String, Class<? extends Component>> KEY_COMP_MAP = new HashMap<>();

    static {
        //在这里统一注册component，也可以调用registerComponent方法注册
        registerComponent(CompEnum.NAME, NameComponent.class);
        registerComponent(CompEnum.INTRO, IntroComponent.class);
        registerComponent(CompEnum.HEAD_IMAGE, HeadImageComponent.class);
        registerComponent(CompEnum.PASSWORD_COMP, PasswordComponent.class);
        registerComponent(CompEnum.MONGO_ID, MongoIdComponent.class);
        registerComponent(CompEnum.MAIL, MailComponent.class);
    }

    /**
     * 注册绑定某个component和其对应的key，因为使用了线程不安全的hashmap所以请在初始化时完成注册动作
     * key可以在序列化时被使用
     *
     * @param key
     * @param clazz
     */
    public static void registerComponent(String key, Class<? extends Component> clazz) {
        KEY_COMP_MAP.put(key, clazz);
        COMP_KEY_MAP.put(clazz, key);
    }

    /**
     * 获取某个component类对应的key
     *
     * @param clazz
     * @return
     */
    public static String getKey(Class<? extends Component> clazz) {
        return COMP_KEY_MAP.get(clazz);
    }

    /**
     * 返回某个key对应的component
     *
     * @param key
     * @return
     */
    public static Class<? extends Component> getComp(String key) {
        return KEY_COMP_MAP.get(key);
    }
}

package com.stu.otsea.ec.component;

import com.stu.otsea.ec.serialize.Serializable;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 16:54
 * @Version: 1.0
 * @Description:
 */
public class UserComponent extends Component implements Serializable<UserComponent> {

    @Override
    public UserComponent stringToObj(String s) {
        return null;
    }

    @Override
    public String objToString() {
        return "";
    }
}

package com.stu.otsea.ec.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stu.otsea.ec.serialize.Serializable;

import java.time.LocalDateTime;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 16:54
 * @Version: 1.0
 * @Description:
 */
public class UserComponent extends Component implements Serializable<UserComponent>{
    private int id;
    private String name;
    private String signature;
    private String headImage;
    private LocalDateTime registerDate;

    @Override
    public void stringToObj(String s) throws IllegalAccessException, InstantiationException {
        JSONObject json= JSONObject.parseObject(s);
        this.id=json.getInteger("id");
        this.name=json.getString("name");
        this.signature=json.getString("signature");
        this.headImage=json.getString("headImage");

        // todo 还有localDateTime序列化
    }

    @Override
    public String objToString() {
        return JSONObject.toJSON(this).toString();
    }
}

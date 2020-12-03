package com.stu.otsea.ec.component;

import com.alibaba.fastjson.JSONObject;
import com.stu.otsea.ec.common.InitializeComp;
import com.stu.otsea.ec.component.abstractComp.OutputComponent;
import com.stu.otsea.ec.enumreation.UserEnum;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 16:54
 * @Version: 1.0
 * @Description:
 */
public class UserComponent extends OutputComponent implements InitializeComp {
    private String name;
    private String signature;
    private String headImage;

    @Override
    public void stringToObj(String s) {
        JSONObject json = JSONObject.parseObject(s);
        this.name = json.getString(UserEnum.NAME);
        this.signature = json.getString(UserEnum.SIGNATURE);
        this.headImage = json.getString(UserEnum.HEAD_IMAGE);
    }

    @Override
    public String objToString() {
        return JSONObject.toJSON(this).toString();
    }

    @Override
    public void initComp() {
        this.name = "这是默认名字";
        this.signature = "这个人很懒，没有设置个性签名";
        this.headImage = "defaultHeadImage";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}

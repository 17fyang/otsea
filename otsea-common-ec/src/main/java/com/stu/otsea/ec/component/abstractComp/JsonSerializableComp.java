package com.stu.otsea.ec.component.abstractComp;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stu.otsea.ec.common.JsonWriteableComp;
import com.stu.otsea.ec.common.ReadableComp;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 15:11
 * @Description:
 * @since JDK 1.8
 */
public abstract class JsonSerializableComp extends Component implements ReadableComp, JsonWriteableComp {

    /**
     * 转成Json的方法，子类实现
     *
     * @return
     */
    @JsonValue
    public abstract JSONObject objToJson();

}

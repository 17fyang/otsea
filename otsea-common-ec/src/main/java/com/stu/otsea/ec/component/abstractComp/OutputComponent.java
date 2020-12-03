package com.stu.otsea.ec.component.abstractComp;


import com.fasterxml.jackson.annotation.JsonValue;
import com.stu.otsea.ec.common.SerializableComp;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 15:11
 * @Description:
 * @since JDK 1.8
 */
public abstract class OutputComponent extends Component implements SerializableComp {

    @JsonValue
    @Override
    public String toString() {
        return this.objToString();
    }
}

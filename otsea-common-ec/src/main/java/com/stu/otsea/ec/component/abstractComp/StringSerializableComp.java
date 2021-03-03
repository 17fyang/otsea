package com.stu.otsea.ec.component.abstractComp;

import com.fasterxml.jackson.annotation.JsonValue;
import com.stu.otsea.ec.common.ReadableComp;
import com.stu.otsea.ec.common.StringWriteableComp;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/3/3 20:34
 * @Description:
 */
public abstract class StringSerializableComp extends Component implements ReadableComp, StringWriteableComp {

    @Override
    @JsonValue
    public abstract String objToString();
}

package com.stu.otsea.ec.component;

import com.stu.otsea.ec.common.ReadableComp;
import com.stu.otsea.ec.component.abstractComp.Component;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/3 15:57
 * @Description:
 * @since JDK 1.8
 */
public class MongoIdComponent extends Component implements ReadableComp {
    private String _id;

    @Override
    public void stringToObj(String s) {
        this._id = s;
    }

    public String get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return _id;
    }
}

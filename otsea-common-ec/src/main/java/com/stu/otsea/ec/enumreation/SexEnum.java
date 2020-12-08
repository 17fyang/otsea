package com.stu.otsea.ec.enumreation;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/8 14:07
 * @Description:
 */
public enum SexEnum {
    MAN("男"),
    WOMAN("女"),
    UNKNOWN("未设置");

    private String value;

    SexEnum(String value) {
        this.value = value;
    }

    public static SexEnum valueOfSex(String value) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getValue().equals(value)) return sex;
        }
        return SexEnum.UNKNOWN;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}

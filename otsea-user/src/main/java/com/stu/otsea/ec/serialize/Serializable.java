package com.stu.otsea.ec.serialize;

public interface Serializable<T> {
    void stringToObj(String s) throws IllegalAccessException, InstantiationException;

    String objToString();
}

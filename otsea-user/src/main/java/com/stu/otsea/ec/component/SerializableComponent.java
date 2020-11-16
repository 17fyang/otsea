package com.stu.otsea.ec.component;

public interface SerializableComponent<T extends Component> {
    T stringToComp(String s);

    String compToString(T comp);

}

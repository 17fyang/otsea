package com.stu.otsea.util.user.component;

public interface SerializableComponent<T extends Component> {
    T stringToComp(String s);

    String compToString(T comp);

}

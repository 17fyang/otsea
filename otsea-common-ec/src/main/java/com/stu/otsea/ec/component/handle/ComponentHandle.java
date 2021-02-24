package com.stu.otsea.ec.component.handle;

import com.stu.otsea.ec.component.abstractComp.Component;
import com.stu.otsea.ec.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/12 16:51
 * @Version: 1.0
 * @Description:
 */
@SuppressWarnings("all")
public class ComponentHandle<T extends Component> {
    private static Logger logger = LoggerFactory.getLogger(ComponentHandle.class);
    private final Class<T> compClass;

    private ComponentHandle(Class<T> compClass) {
        this.compClass = compClass;
    }

    /**
     * 构建一个handle
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Component> ComponentHandle<T> buildHandle(Class<T> clazz) {
        ComponentHandle<T> newHanle = new ComponentHandle<T>(clazz);
        return newHanle;
    }

    /**
     * 给某个entity绑定compnent，如果已绑定则直接返回
     *
     * @param entity
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public T bindComponent(Entity entity) {
        Component comp = entity.getComponentMap().get(this.compClass);
        if (comp != null) return (T) comp;
        T compInstance = null;
        try {
            compInstance = compClass.newInstance();
            entity.getComponentMap().put(this.compClass, compInstance);
            return compInstance;
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to new component instance!");
        }
    }

    /**
     * 移除某个entity的component
     *
     * @param entity
     * @return
     */
    public T removeComponent(Entity entity) {
        return (T) entity.getComponentMap().remove(this.compClass);
    }
}

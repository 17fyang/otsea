package com.stu.otsea.ec.entity;

import com.stu.otsea.ec.common.ReadableComp;
import com.stu.otsea.ec.common.WriteableComp;
import com.stu.otsea.ec.component.abstractComp.Component;
import com.stu.otsea.ec.component.handle.ComponentRegister;
import org.bson.Document;

import java.util.Map;
import java.util.Set;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/16 19:31
 * @Version: 1.0
 * @Description:
 */

@SuppressWarnings("all")
public class User extends Entity {

    /**
     * User对象序列化成mongodb文档
     *
     * @return
     */
    public Document toMongoDocument() {
        Document doc = new Document();

        Map<Class<? extends Component>, Component> componentMap = this.getComponentMap();
        if (componentMap == null || componentMap.isEmpty()) return doc;

        for (Map.Entry<Class<? extends Component>, Component> entry : componentMap.entrySet()) {
            Component comp = entry.getValue();
            if (comp instanceof WriteableComp) {
                WriteableComp writeableComp = (WriteableComp) comp;
                String key = ComponentRegister.getKey(entry.getKey());
                doc.put(key, writeableComp.objToString());
            }
        }
        return doc;
    }

    /**
     * mongodb 文档反序列化成User对象
     *
     * @param doc
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static User packFromMongoDocument(Document doc) throws IllegalAccessException, InstantiationException {
        return User.packFromEntrySet(doc.entrySet());
    }

    /**
     * entrySet 反序列化成User对象
     *
     * @param entrySet
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static User packFromEntrySet(Set<Map.Entry<String, Object>> entrySet) throws IllegalAccessException, InstantiationException {
        User user = new User();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue().toString();

            Class<? extends Component> compClass = ComponentRegister.getComp(key);
            if (compClass != null) {
                Component comp = compClass.newInstance();

                //不处理没有实现ReadableComp的component
                if (!(comp instanceof ReadableComp)) continue;

                ReadableComp readableComp = (ReadableComp) comp;
                readableComp.stringToObj(value);
                user.getComponentMap().put(compClass, comp);
            }
        }
        return user;
    }
}

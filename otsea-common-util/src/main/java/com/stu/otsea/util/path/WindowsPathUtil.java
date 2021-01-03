package com.stu.otsea.util.path;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 14:53
 * @Description:
 */
public class WindowsPathUtil implements PathUtil {
    public static final String RESOURCE_ROOT = System.getProperty("user.dir") + "/config";
    public static final String STATIC_ROOT = System.getProperty("user.dir") + "static";

    @Override
    public String getConfigRoot() {
        return RESOURCE_ROOT;
    }

    @Override
    public String getConfig(String sonPath) {
        return RESOURCE_ROOT + sonPath;
    }

    @Override
    public String getStaticRoot() {
        return STATIC_ROOT;
    }

    @Override
    public String getStatic(String sonPath) {
        return STATIC_ROOT + sonPath;
    }
}

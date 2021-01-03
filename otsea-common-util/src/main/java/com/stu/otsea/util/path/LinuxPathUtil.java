package com.stu.otsea.util.path;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 14:49
 * @Description:
 */
public class LinuxPathUtil implements PathUtil {
    public static final String RESOURCE_ROOT = "/software/workSpace/otsea/config";
    public static final String STATIC_ROOT = "/software/workSpace/otsea/static";

    @Override
    public String getStatic(String sonPath) {
        return STATIC_ROOT + sonPath;
    }

    @Override
    public String getStaticRoot() {
        return STATIC_ROOT;
    }

    @Override
    public String getConfig(String sonPath) {
        return RESOURCE_ROOT + sonPath;
    }

    public String getConfigRoot() {
        return RESOURCE_ROOT;
    }
}

package com.stu.otsea.util.path;

import java.io.File;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2021/1/3 14:51
 * @Description:
 */
public class AutoPathUtil implements PathUtil {
    private PathUtil pathUtil;
    private static AutoPathUtil instance = new AutoPathUtil();

    private AutoPathUtil() {
        if ("\\".equals(File.separator))
            pathUtil = new WindowsPathUtil();
        else
            pathUtil = new LinuxPathUtil();
    }

    public static AutoPathUtil getInstance() {
        return instance;
    }


    @Override
    public String getConfigRoot() {
        return pathUtil.getConfigRoot();
    }

    @Override
    public String getConfig(String sonPath) {
        return pathUtil.getConfig(sonPath);
    }

    @Override
    public String getStaticRoot() {
        return pathUtil.getStaticRoot();
    }

    @Override
    public String getStatic(String sonPath) {
        return pathUtil.getStatic(sonPath);
    }
}

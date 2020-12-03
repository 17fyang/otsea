package com.stu.otsea.web.path;

import java.io.File;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/11 20:27
 * @Version: 1.0
 * @Description:
 */
public class PathUtil {
    public static final String RESOURCE_ROOT;

    static {
        RESOURCE_ROOT = new File("").getAbsolutePath() + "\\target\\classes\\";
    }

    /**
     * 获取资源绝对路径
     *
     * @param resourceName 资源名称
     * @return 绝对路径
     */
    public static String getResourcePath(String resourceName) {
        return RESOURCE_ROOT + resourceName;
    }

    /**
     * 获取resource文件夹根路径
     *
     * @return 根路径
     */
    public static String getResourceRoot() {
        return RESOURCE_ROOT;
    }
}

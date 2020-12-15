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
        if ("\\".equals(File.separator)) {
            // 如果是windows系统则使用项目根目录的配置
            String itemLocation = System.getProperty("user.dir");
            RESOURCE_ROOT = itemLocation + "/config";
        } else {
            //如果是linux系统则使用指定位置的配置
            RESOURCE_ROOT = "/software/workSpace/otsea/config";
        }
        System.out.println("locate config resource location:" + RESOURCE_ROOT);
    }

    /**
     * 获取资源绝对路径
     *
     * @param resourceName 资源名称
     * @return 绝对路径
     */
    public static String getResourcePath(String resourceName) {
        return RESOURCE_ROOT + "/" + resourceName;
    }

    /**
     * 获取配置文件夹根路径
     *
     * @return 根路径
     */
    public static String getResourceRoot() {
        return RESOURCE_ROOT;
    }
}

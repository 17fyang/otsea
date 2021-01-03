package com.stu.otsea.util.path;

/**
 * @Author: 乌鸦坐飞机亠
 * @CreateDate: 2020/11/11 20:27
 * @Version: 1.0
 * @Description:
 */
public interface PathUtil {
    /**
     * 获取配置文件夹根路径
     *
     * @return 根路径
     */
    String getConfigRoot();

    /**
     * 获取配置文件资源绝对路径
     *
     * @param sonPath 资源名称
     * @return 绝对路径
     */
    String getConfig(String sonPath);

    /**
     * 获取静态资源根路径
     *
     * @return
     */
    String getStaticRoot();

    /**
     * 获取静态资源子路径对应的绝对路径
     *
     * @param sonPath
     * @return
     */
    String getStatic(String sonPath);

}

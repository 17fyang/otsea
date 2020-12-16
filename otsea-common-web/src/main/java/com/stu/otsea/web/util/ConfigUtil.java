package com.stu.otsea.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/16 15:42
 * @Description:
 */
public class ConfigUtil {
    private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
    private Properties properties;

    public ConfigUtil(String propertiesPath) {
        try (InputStream in = new FileInputStream(propertiesPath)) {
            properties = new Properties();
            properties.load(in);
        } catch (Exception e) {
            logger.error("error!! 加载配置文件:{}失败", propertiesPath);
            e.printStackTrace();
        }
    }

    /**
     * 获取String型的配置
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return properties.getProperty(key);
    }

    /**
     * 获取int型的配置
     *
     * @param key
     * @return
     */
    public int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

}

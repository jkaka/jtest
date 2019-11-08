package com.kaka.common.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 10:41
 */
public class PropertiesUtil {
    public static String getLocalProperty(String key) {
        String defaultPath = System.getProperty("user.home") + "/jsk.properties";
        String value;
        try {
            value = getProperty(key, defaultPath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return value;
    }

    public static String getLocalProperty(String key, String defaultValue) {
        String value = getLocalProperty(key);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public static String getProperty(String key, String path) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }
}

package com.kaka.jtest.springboot.common.utils.jvm;

import java.lang.reflect.Method;

/**
 * @author: jsk
 * @date: 2019/3/25 20:30
 */
public class JavaClassUtil {

    public static String execute(String name, byte[] bytes) throws Exception {
        HotSpotClassLoader hotSpotClassLoader = new HotSpotClassLoader();
        Class aClass = hotSpotClassLoader.loadByte(name, bytes);
        Method main = aClass.getMethod("main", new Class[]{String[].class});
        main.invoke(null, new String[]{null});
        return "";
    }

    public static String compile(String name, byte[] bytes) throws Exception {
        HotSpotClassLoader hotSpotClassLoader = new HotSpotClassLoader();
        hotSpotClassLoader.loadByte(name, bytes);
        return "";
    }
}

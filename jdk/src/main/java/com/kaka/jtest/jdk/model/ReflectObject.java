package com.kaka.jtest.jdk.model;

/**
 * @author: jsk
 * @date: 2019/6/28 14:17
 */
public class ReflectObject {

    /**
     * final+static的变量
     * 防止JVM编译时就把"default4"作为常量处理
     */
    private final static String testStr = (null == null ? "default4" : "");

    public static String getTestStr() {
        return testStr;
    }
}

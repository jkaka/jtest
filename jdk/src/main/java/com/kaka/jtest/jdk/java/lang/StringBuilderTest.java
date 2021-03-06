package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/9/18 14:27
 */
public class StringBuilderTest {

    @Test
    public void appendTest() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test");
        System.out.println(stringBuilder);
    }

    /**
     * 返回值为this，无需接收
     */
    @Test
    public void deleteTest() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test,1");
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        System.out.println(stringBuilder);
        // 删除指定位置的字符
        System.out.println(stringBuilder.deleteCharAt(1));
    }

    @Test
    public void lengthTest() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test");
        stringBuilder.setLength(0);
        System.out.println(stringBuilder);
    }
}

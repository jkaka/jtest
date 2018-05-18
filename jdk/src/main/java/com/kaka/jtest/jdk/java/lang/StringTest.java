package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

public class StringTest {

    /**
     * 判断文件类型
     */
    @Test
    public void testEndWith(){
        String string = "****.html";
        System.out.println(string.endsWith(".html"));
    }

    /**
     * 截取字符串
     * The substring begins at the specified {@code beginIndex} and
     * extends to the character at index {@code endIndex - 1}.
     */
    @Test
    public void substringTest(){
        String string = "abcd";
        System.out.println(string.substring(1));
        System.out.println(string.substring(1,1));
        System.out.println(string.substring(1,2));
    }
}

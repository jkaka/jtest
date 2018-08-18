package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest {

    /**
     * 判断文件类型
     */
    @Test
    public void testEndWith() {
        String string = "****.html";
        System.out.println(string.endsWith(".html"));
    }

    /**
     * 截取字符串
     * The substring begins at the specified {@code beginIndex} and
     * extends to the character at index {@code endIndex - 1}.
     */
    @Test
    public void substringTest() {
        String string = "abcd";
        System.out.println(string.substring(1));
        System.out.println(string.substring(1, 1));
        System.out.println(string.substring(1, 2));
    }

    /**
     * 测试equals
     */
    @Test
    public void equals() {
        String str1 = "aBcd";
        String str2 = "abcd";
        System.out.println(str1.equalsIgnoreCase(str2));
    }

    /**
     * 测试replace
     * 如果没有需要替换的字符串，返回的String对象就是原来的String
     */
    @Test
    public void replace() {
        String str1 = "aBcd";
        String str2 = str1.replace("t", "a");
        System.out.println(str1 == str2);
    }

    /**
     * contains()
     * 是否包含某片段，区分大小写
     */
    @Test
    public void contains() {
        String str1 = "aBcd";
        System.out.println(str1.contains("b"));
    }

    /**
     * null字符串使用“+”连接符不报错！
     */
    @Test
    public void testNull() {
        String test = null;
        String str = "aBcd";
        System.out.println(test + str);
    }

    @Test
    public void test(){
        List<String> strings = new ArrayList<>(Arrays.asList("aa"));
        for(String str : strings){
            str += "1";
        }
        for(String str : strings){
            System.out.println(str);
        }
    }

    /**
     * trim去掉前后空格
     */
    @Test
    public void trim(){
        String str = "    V6.4.2.  A     ";
        System.out.println(str.trim());
    }

    /**
     * \s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
     */
    @Test
    public void replaceAll(){
        String str = "    V6.4.2.  A     ";
        System.out.println(str.replaceAll("\\s+$", ""));
    }

    @Test
    public void lastIndexOf(){
        String fileName = "ab.c.rar";
        System.out.println(fileName.lastIndexOf("."));
        System.out.println(fileName.substring(fileName.lastIndexOf(".")));
    }
}

package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

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
     * 测试replace：不支持使用正则
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
    public void test() {
        List<String> strings = new ArrayList<>(Arrays.asList("aa"));
        for (String str : strings) {
            str += "1";
        }
        for (String str : strings) {
            System.out.println(str);
        }
    }

    /**
     * trim去掉前后空格
     */
    @Test
    public void trim() {
        String str = "    V6.4.2.  A     ";
        System.out.println(str.trim());
    }

    /**
     * replaceAll：替换所有，支持使用正则表达式
     * \s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
     */
    @Test
    public void replaceAll() {
        // 去后空格
        String str = "    V6.4.2.  A     ";
        System.out.println(str.replaceAll("\\s+$", ""));

        // .*：任意字符
        str = "http://ota-prod.oss-cn-hangzhou.aliyuncs.com/development/ad/a54603c98dd867708c525c1ca8a8358f_0Btm.png";
        System.out.println(str.replaceAll("http://.*.oss-cn-hangzhou.aliyuncs.com/", ""));
    }

    @Test
    public void lastIndexOf() {
        String fileName = "ab.c.rar";
        System.out.println(fileName.lastIndexOf("."));
        System.out.println(fileName.substring(fileName.lastIndexOf(".")));
    }

    /**
     * new  就意味着是两个对象
     */
    @Test
    public void newString() {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3 == str4);
    }

    /**
     * 等号从右向左赋值
     */
    @Test
    public void assignment() {
        String str1 = "aa";
        String str2 = "bb";
        String str3 = "cc";
        str1 = str2 = str3;
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    @Test
    public void length(){
        String string = "https://device-platform-tbox-pki.oss-cn-hangzhou.aliyuncs.com/2700471017035359HC800151.p12" + System.currentTimeMillis();
        System.out.println(string.length());
    }

}

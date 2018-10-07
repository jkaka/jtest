package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * regular expression：Regex
 * 正则表达式测试类
 *
 * @author jsk
 * @Date 2018/10/6 11:28
 */
public class StringRegexTest {

    /**
     * 字符串与正则表达式是否匹配
     * ？：可能有一个...
     * \d 是一个数字
     * \d+：多个数字
     * 注意：在java中使用反斜杠时，需要再加一个反斜杠进行转义
     */
    @Test
    public void matchesTest() {
        // -?\d+：这个字符串是一个或多个数字，最前面可能有一个问号
        System.out.println("1234".matches("-?\\d+"));
        System.out.println("-1234".matches("-?\\d+"));

        // -?\d+：这个字符串是一个数字，最前面可能有一个问号
        System.out.println("1234".matches("-?\\d"));

        // (-|\+)?\d+：这个字符串前面可能有一个减号或者加号，后面跟着一个或者多个数字
        System.out.println("+1234".matches("(-|\\+)?\\d+"));
    }
}

package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.Formatter;

/**
 * @author shuangkaijia
 */
public class FormatterTest {

    @Test
    public void format() {
        Formatter formatter = new Formatter(System.out);

        formatter.format("%-15s %-5s %-10s\n", "huhx", "linux", "liuli");
        formatter.format("%-15s %-5s %-10s\n", "zhangkun", "yanzi", "zhangcong");
        formatter.format("%-15s %-5s %-10s\n", "zhangkun", "yanzhou", "zhangcong");
    }
}

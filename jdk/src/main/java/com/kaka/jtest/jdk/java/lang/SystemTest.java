package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class SystemTest {
    @Test
    public void test() throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(100L);
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
    }
}

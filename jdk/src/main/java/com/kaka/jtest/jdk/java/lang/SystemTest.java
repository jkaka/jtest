package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class SystemTest {
    /**
     * 获取当前时间的毫秒数
     * @throws InterruptedException
     */
    @Test
    public void currentTimeMillis() throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(100L);
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
    }

    /**
     * 获取环境变量
     */
    @Test
    public void getenv(){
        String path=System.getenv("a");
        System.out.println(path);
    }
}

package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class SystemTest {
    /**
     * 获取当前时间的毫秒数
     *
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
    public void getenv() {
        String path = System.getenv("a");
        System.out.println(path);

        // 获取用户名
        String username = System.getenv("username");
        System.out.println(username);
    }

    @Test
    public void getProperty() {
        String machineId = System.getProperty("machine_Id");
        System.out.println(machineId);
    }
}

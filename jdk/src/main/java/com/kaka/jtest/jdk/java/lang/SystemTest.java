package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class SystemTest {

    @Test
    public void arrayCopy(){
        Object[] objects = new Object[]{"aa"};
        String[] strings = new String[2];
        System.arraycopy(objects, 0, strings, 0, 1);
        System.out.println(strings);
    }

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

        String osName = System.getProperty("os.name");
        System.out.println(osName);

        String osVersion = System.getProperty("os.version");
        System.out.println(osVersion);

        String arch = System.getProperty("os.arch");
        System.out.println(arch);

        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);
    }
}

package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

    /**
     * 获取properties文件中的内容
     */
    @Test
    public void getPropertyTest() throws Exception {
        // 非静态方法中可以用
        // 默认是从当前类的同级目录中寻找配置文件，加上一个/代表从类的根路径中寻找配置文件
        InputStream is = this.getClass().getResourceAsStream("/jdk.properties");
        Properties properties = new Properties();
        properties.load(is);
        // properties文件会自动除去key和value前后的空格，中间的不会去掉
        String name = properties.getProperty("name");
        System.out.println(name);
    }
}

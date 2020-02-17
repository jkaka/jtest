package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * Float功能测试
 *
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/02/03 20:05:14
 */
public class FloatTest {

    @Test
    public void equal() {
        float a = 0.3f;
        float b = 0.9f / 0.3f;
        float c = 3 / 10;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(a == b);
    }
}

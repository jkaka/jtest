package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author jiashuangkai
 * @date 2019/12/20 19:16:00
 */
public enum EnumTest {
    /**
     *
     */
    TEST_01,TEST_02;

    @Test
    public void nameTest(){
        System.out.println(TEST_01.name());
    }
}

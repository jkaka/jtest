package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/9/18 14:27
 */
public class StringBuilderTest {

    @Test
    public void appendTest(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test");
        System.out.println(stringBuilder);
    }


    @Test
    public void deleteTest(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test");
        stringBuilder.delete(0, stringBuilder.length());
        System.out.println(stringBuilder);
    }

    @Test
    public void lengthTest(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test");
        stringBuilder.setLength(0);
        System.out.println(stringBuilder);
    }
}

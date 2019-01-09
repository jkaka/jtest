package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.Random;

/**
 * @author jsk
 * @Date 2018/12/13 17:33
 */
public class RandomTest {
    @Test
    public void nextInt(){
        Random random = new Random();
        System.out.println(random.nextInt());
    }
}

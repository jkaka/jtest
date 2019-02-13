package com.kaka.jtest.jdk.java8.util;

import org.junit.Test;

import java.util.Random;

/**
 * @author jsk
 * @Date 2019/2/13 17:36
 */
public class RandomTest {

    @Test
    public void nextInt(){
        Random random = new Random();
        // [0, 100)
        System.out.println(random.nextInt(100));
        System.out.println(new Random().nextInt(100));
    }
}

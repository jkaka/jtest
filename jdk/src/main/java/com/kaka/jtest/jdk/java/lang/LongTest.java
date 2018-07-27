package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LongTest {

    /**
     * 与Integer类型一样的值，去比较
     */
    @Test
    public void compare2integer() {
        List<Integer> matCodeIds = Arrays.asList(1, 2, 5);
        Long num = 1L;
        System.out.println(matCodeIds.contains(num));
    }
}

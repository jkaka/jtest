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

    @Test
    public void compare2integerType() {
        Integer one = 0;
        Long one1 = 0L;
        // 编译报错
        // System.out.println(one == one1);

    }

    /**
     * 与普通值比较,返回true
     */
    @Test
    public void compare2common(){
        System.out.println(0 == 0L);
    }


    @Test
    public void equals(){
        Long a = 10L;
        Long b =10L;
        System.out.println(a.equals(b));
    }

    @Test
    public void max(){
        System.out.println(Long.MAX_VALUE);
    }
}

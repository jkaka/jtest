package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

public class MathTest {

    /**
     * 除号的意思为取整，10里面只有1个6
     */
    @Test
    public void division(){
        System.out.println(10/6);
    }

    @Test
    public void a(){
        System.out.println("9:1001");
        System.out.println(9 >> 2);
    }
}

package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class MathTest {

    /**
     * 1.除号的意思为取整，10里面只有1个6
     * 2.按除号两边精度高的保存结果
     */
    @Test
    public void division() {
        System.out.println(10 / 6);
        long age = System.currentTimeMillis();
        // 返回float型
        System.out.println(age / (24 * 3600000f));
        // 返回长整型型
        System.out.println(age / (24 * 3600000));
    }

    @Test
    public void a() {
        System.out.println("9:1001");
        System.out.println(9 >> 2);
    }

    /**
     * 取上整，返回double类型
     */
    @Test
    public void ceil(){
        System.out.println(Math.ceil(61 / 60.0));
    }

    @Test
    public void test(){
        long a;
        double b = 33.10;
        a = Math.round(b);
        System.out.println(a);
    }
}

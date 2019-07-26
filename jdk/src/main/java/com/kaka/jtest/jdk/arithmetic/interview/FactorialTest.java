package com.kaka.jtest.jdk.arithmetic.interview;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author: jsk
 * @date: 2019/6/14 11:52
 */
public class FactorialTest {

    @Test
    public void run() {
        System.out.println(factorial(20));
        System.out.println(recursion(20));
    }

    /**
     * 循环方式
     *
     * @param n
     * @return
     */
    public static BigDecimal factorial(long n) {
        if (n < 0) {
            throw new RuntimeException("不能输入负数");
        }
        if (n == 0 || n == 1) {
            return new BigDecimal(1);
        }

        BigDecimal sum = new BigDecimal(1);
        for (long i = 1; i <= n; i++) {
            sum = sum.multiply(new BigDecimal(i));
        }
        return sum;
    }


    /**
     * 递归方式,可能导致调用栈溢出
     *
     * @param n
     * @return
     */
    public static BigDecimal recursion(long n) {
        if (n < 0) {
            throw new RuntimeException("不能输入负数");
        }
        BigDecimal bigDecimal = new BigDecimal(n);
        if (n > 1) {
            bigDecimal = bigDecimal.multiply(recursion(n - 1));
        } else {
            return new BigDecimal(1);
        }
        return bigDecimal;
    }
}

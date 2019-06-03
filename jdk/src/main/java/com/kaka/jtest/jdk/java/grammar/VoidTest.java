package com.kaka.jtest.jdk.java.grammar;

import java.util.Arrays;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/5/30 17:20
 */
public class VoidTest {

    public static void main(String[] args) {
        returnTest();
        forEachReturnTest();
    }

    public static void returnTest() {
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                System.out.println("输出:" + i);
            } else {
                System.out.println("程序结束!");
                return;
            }
        }
    }

    /**
     * forEach的方法中return不会结束程序;仅结束本次循环,相当于continue
     */
    public static void forEachReturnTest() {
        List<String> list = Arrays.asList("AA", "BB", "CC", "DD");
        list.forEach(s -> {
            if (s.equals("CC")) {
                System.out.println("程序结束!");
                return;
            } else {
                System.out.println("打印结果:" + s);
            }
        });
    }
}

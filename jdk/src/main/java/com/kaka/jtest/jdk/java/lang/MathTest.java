package com.kaka.jtest.jdk.java.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class MathTest {

    /**
     * 1.按除号两边精度高的保存结果
     * 2.除号两边为整数时,结果取下整：10里面只有1个6
     */
    @Test
    public void division() {
        long age = System.currentTimeMillis();
        // 返回float型
        System.out.println(age / (24 * 3600000f));
        // 返回长整型型
        System.out.println(age / (24 * 3600000));

        System.out.println(10 / 9);
        System.out.println(10 / 6.0);
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
    public void ceil() {
        System.out.println(Math.ceil(61 / 60.0));
    }

    @Test
    public void round() {
        double b = 33.50;
        long a = Math.round(b);
        System.out.println(a);
        System.out.println(Math.round(-1.4));
    }

    @Test
    public void test() {
        // 左移30位：2的30次方
        System.out.println(1 << 30);
    }

    @Test
    public void lottery() {
        List<Integer> list = new ArrayList<>();
        List<Integer> integers = Arrays.asList(1, 6, 7, 9, 10, 2, 11);
        int count = 1;
        System.out.println(new Date());
        while (true) {
            list.clear();
            count ++;
            for (int i = 0; i < 7; i++) {
                if (i < 5) {
                    int num = new Double(Math.random() * 35 + 1).intValue();
                    list.add(num);
                } else {
                    list.add(new Double(Math.random() * 12 + 1).intValue());
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals(integers.get(i))) {
                    break;
                }
                if (i == 6) {
                    System.out.println(list);
                    System.out.println(new Date());
                    System.out.println(count);
                    return;
                }
            }
        }
    }
}

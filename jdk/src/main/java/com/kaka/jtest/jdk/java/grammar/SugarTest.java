package com.kaka.jtest.jdk.java.grammar;

import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/3/29 21:44
 */
public class SugarTest {

    @Test
    public void test() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        // false   类型不同
        System.out.println(g.equals(a + b));
    }

    /**
     * 只有if能配合常量进行"条件编译"
     */
    public void conditionCompile() {
       /* while (false){
            System.out.println();
        }*/

        if (false) {

        } else {
            System.out.println("生成字节码时,只有这一条语句");
        }
    }
}

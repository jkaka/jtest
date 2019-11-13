package com.kaka.jtest.jdk.java.grammar;

import org.junit.Test;

import java.util.Random;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-12 10:16
 */
public class WhileTest {

    /**
     * break只能跳出当前循环
     * return 能结束方法，无论在几个内层的循环中
     */
    @Test
    public void innerFor() {
        while (true) {
            Random random = new Random();
            int nextInt = random.nextInt(10);
            for (int i = 0; i < 10; i++) {
                if (i == nextInt) {
                    System.out.println("仅仅结束for循环!");
                    break;
                }
                if(nextInt == 6){
                    System.out.println("return  结束整个方法!");
                    return;
                }
            }
        }
    }
}

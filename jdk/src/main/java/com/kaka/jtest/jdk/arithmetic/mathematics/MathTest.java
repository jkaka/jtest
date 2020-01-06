package com.kaka.jtest.jdk.arithmetic.mathematics;

import org.junit.Test;

/**
 * 类功能描述
 *
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2019/12/31 21:10:10
 */
public class MathTest {

    /**
     * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
     * 若x是二进制数0101，y是二进制数1011；
     * 则x⊕y=1110
     */
    @Test
    public void xor(){
        System.out.println(13^0);
        System.out.println(0^0);
        System.out.println(1^1);
        System.out.println(0^15);
    }
}

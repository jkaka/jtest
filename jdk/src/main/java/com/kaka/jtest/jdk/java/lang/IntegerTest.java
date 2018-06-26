package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

/**
 * @author shuangkaijia
 */
public class IntegerTest {

    /**
     * 测试Integer的边界
     * int占4个字节，共32位；第一位是符号位，所以最大为+2147483647(2的31次方减去1,因为包含0)、最小为-2147483648
     */
    @Test
    public void boundary() {
        Integer integer = new Integer(2);
        for (int i = 1; i <= 32; i++) {
            System.out.println("第" + i + "位：" + new Double(Math.pow(integer, i - 1)).intValue());
        }
    }
}

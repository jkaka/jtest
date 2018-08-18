package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 多个数值连乘时，会把结果先暂存在这个数值类型的一个临时变量中
     */
    @Test
    public void boundary1() {
        long a = 1L;
        long time1 = a * 3600 * 24 * 1000 * 25;
        long time2 = 3600L * 24 * 1000 * 25;
        long time3 = 3600 * 24 * 1000 * 25;
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
    }


    /**
     * final int value;  value字段不可改变，如果改变就是新的integer对象
     */
    @Test
    public void value() {
        Map<String, String> map = new HashMap<>();
        Integer update = 0;
        map.put("aa", update + "");
        update = 2999999;
        System.out.println(map.get("aa"));
    }

    @Test
    public void max() {
        Integer max = 1024 * 1024 * 1024;
        System.out.println(max);
    }
}

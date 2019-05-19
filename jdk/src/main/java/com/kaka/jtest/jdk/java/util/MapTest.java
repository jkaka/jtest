package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuangkaijia
 */
public class MapTest {


    /**
     * 初始容量(可扩展)
     */
    @Test
    public void initialCapacity() {
        Map<String, String> map = new HashMap<>(2);
        map.put("AA", "a");
        map.put("BB", "b");
        map.put("CC", "c");
        map.put("DD", "d");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }

    /**
     * key可以为null
     */
    @Test
    public void nullTest() {
        Map<String, String> map = new HashMap<>(2);
        map.put("abc", "a");
        map.put(null, "b");
        System.out.println(map.get(null));

        System.out.println("abc".hashCode());
        int h;
        System.out.println((h = "abc".hashCode()) ^ (h >>> 16));
        // 如何保证均匀?即使利用^亦或的方法,因为&和|都会使得结果偏向0或者1 ,并不是均匀的概念,


        System.out.println((16-1)&3);
    }

    @Test
    public void hash() {
        // 1.hash值重新计算
        String key = "abc";
        int h;
        // 为了使高位也能影响取余的结果:使用hashcode亦或hashCode右移16位
        // 使用亦或的原因:为了保证均匀,即使利用^亦或的方法;因为&和|都会使得结果偏向0或者1 ,并不是均匀的概念
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(hash);

        // 2.取下标
        int n = 1 << 18;
        // 位与运算:当hash大于n时,相当于对n求余
        int index = (n - 1) & hash;
        System.out.println(index);
        System.out.println(2 % 8);
    }

    @Test
    public void tableSizeFor(){
        final int MAXIMUM_CAPACITY = 1 << 30;
        int cap = 5;
        int n = cap - 1;// 4 = 0 1 0 0    减去1,应该是为了防止越界
        // 这五个步骤能使n的所有位都是1
        n |= n >>> 1;// 0 1 0 0 | 0 0 1 0 = 0 1 1 0 = 6        右移1位,至少前2位变成1了,所以下次右移2位
        n |= n >>> 2;// 0 1 1 0 | 0 0 0 1 = 0 1 1 1 = 7        右移2位,至少前4位变成1了,所以下次右移4位
        n |= n >>> 4;// 0 1 1 1 | 0 0 0 0 = 0 1 1 1 = 7        右移4位,至少前8位变成1了,所以下次右移8位
        n |= n >>> 8;// 0 1 1 1 | 0 0 0 0 = 0 1 1 1 = 7
        n |= n >>> 16;// 0 1 1 1 | 0 0 0 0 = 0 1 1 1 = 7
        int size = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;// 7 + 1 = 8
        System.out.println(size);
    }
}

package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jsk
 * @date: 2019/8/28 13:57
 */
public class HashMapTest {

    /**
     * size代表map中数据的个数,不是容量
     */
    @Test
    public void sizeTest(){
        Map<String, String> map = new HashMap<>(16);
        map.put("abc", "a");
        System.out.println(map.size());
    }
}

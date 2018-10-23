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
        map.put(null, "a");
        System.out.println(map.get(null));
    }
}

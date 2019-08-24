package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 按自然顺序或自定义顺序遍历键
 *
 * @author: jsk
 * @date: 2019/8/22 19:55
 */
public class TreeMapTest {

    @Test
    public void putTest() {
        Map<String, String> map = new TreeMap<>();
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}

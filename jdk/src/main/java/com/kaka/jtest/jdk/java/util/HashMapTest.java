package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个桶中的元素数量大于8个时，使用红黑树而不是链表
 *
 * 在resize的过程中，如果桶中的元素小于6个，将树转换为链表
 *
 * 只有hashmap容量大于64时，才可以树化
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

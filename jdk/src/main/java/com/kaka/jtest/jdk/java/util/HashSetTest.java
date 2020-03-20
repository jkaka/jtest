package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * hashSet底层由hashMap实现
 *
 * @author: jsk
 * @date: 2019/8/14 14:02
 */
public class HashSetTest {

    /**
     * 如果值已存在则返回false
     */
    @Test
    public void addTest() {
        Set<String> stringSet = new HashSet<>(4);
        System.out.println(stringSet.add("a"));
        System.out.println(stringSet.add("a"));
        System.out.println(stringSet);
    }

    /**
     * 如果要移除的对象不存在，则返回false
     */
    @Test
    public void removeTest() {
        Set<String> stringSet = new HashSet<>(4);
        stringSet.add("a");
        System.out.println(stringSet.remove("a"));
        System.out.println(stringSet.remove("a"));
    }
}

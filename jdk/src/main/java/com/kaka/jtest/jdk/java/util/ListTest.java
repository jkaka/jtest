package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    /**
     * 测试list的remove(Object o)方法
     */
    @Test
    public void removeObject(){
        List<String> strings = new ArrayList<>();
        System.out.println(strings.remove("a"));
    }

    @Test
    public void removeIndex(){
        List<String> strings = new ArrayList<>();
        System.out.println(strings.remove(1));
    }

    /**
     * 把list声明为final，依然可以添加item
     */
    @Test
    public void testFinal(){
        final List<String> strings = new ArrayList<>();
        System.out.println(strings.size());
        strings.add("AAa");
        System.out.println(strings.size());
    }
}

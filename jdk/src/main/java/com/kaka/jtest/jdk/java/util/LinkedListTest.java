package com.kaka.jtest.jdk.java.util;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/07 22:21:08
 */
public class LinkedListTest {
    @Test
    public void construct(){
        List<String> stringLinkedList = new LinkedList<>();
        System.out.println(stringLinkedList);
    }

    @Test
    public void get(){
        List<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("a");
        stringLinkedList.add("b");
        String s = stringLinkedList.get(1);
        System.out.println(s);
    }

    @Test
    public void add(){

    }
}

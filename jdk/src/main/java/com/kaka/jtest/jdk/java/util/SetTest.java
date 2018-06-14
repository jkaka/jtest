package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

    /**
     * list转换为set
     */
    @Test
    public void listToSet(){
        Set set = new HashSet(Arrays.asList("AA", "BB", "aa", "AA"));
        set.addAll(Arrays.asList("AA", "CC", "aa", "AA"));
        System.out.println(set);
    }
}

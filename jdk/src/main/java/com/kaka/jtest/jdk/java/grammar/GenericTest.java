package com.kaka.jtest.jdk.java.grammar;

import java.util.List;

/**
 * @author: jsk
 * @date: 2019/3/29 21:37
 */
public class GenericTest {

    public void method(List<String> list) {
    }

    // 因为泛型会擦出,所以编译不会通过(都会变成原生类型)
    // public void method(List<Integer> list) {}
}

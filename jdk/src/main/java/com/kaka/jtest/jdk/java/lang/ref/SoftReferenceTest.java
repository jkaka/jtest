package com.kaka.jtest.jdk.java.lang.ref;

import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * @author: jsk
 * @date: 2019/9/19 15:47
 */
public class SoftReferenceTest {
    @Test
    public void getTest() {
        Object obj = new Object();
        SoftReference<Object> soft = new SoftReference<>(obj);
        obj = null;
        System.gc();
        System.out.println(soft.get());
    }
}

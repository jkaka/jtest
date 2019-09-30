package com.kaka.jtest.jdk.java.lang.ref;

import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * 若仅有软引用在使用某值，当内存满了并发生gc后，就会回收该值
 *
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

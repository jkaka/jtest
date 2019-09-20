package com.kaka.jtest.jdk.java.lang.ref;

import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * @author: jsk
 * @date: 2019/9/19 15:48
 */
public class WeakReferenceTest {

    @Test
    public void getTest(){
        Object obj = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        obj = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}

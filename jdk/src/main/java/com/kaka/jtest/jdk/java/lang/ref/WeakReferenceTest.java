package com.kaka.jtest.jdk.java.lang.ref;

import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * 弱引用：若仅有弱引用在使用某值，下次gc该值就会被回收
 *
 * @author: jsk
 * @date: 2019/9/19 15:48
 */
public class WeakReferenceTest {

    @Test
    public void getTest() {
        Object obj = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        // 此时gc不会回收弱引用中的值,因为这个值有一个强引用obj在使用
        System.gc();
        System.out.println(weakReference.get());

        // obj释放引用,下次gc弱引用也留不住这个值了
        obj = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}

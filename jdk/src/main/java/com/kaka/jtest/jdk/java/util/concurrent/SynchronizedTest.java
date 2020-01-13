package com.kaka.jtest.jdk.java.util.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import com.kaka.jtest.jdk.model.SynchronizedObject;

/**
 * 测试synchronized关键字
 *
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/01/13 21:28:01
 */
public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        CompletableFuture.runAsync(() -> {
            try {
                synchronizedObject.methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture.runAsync(() -> {
            try {
                synchronizedObject.methodB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        CompletableFuture.runAsync(() -> {
            try {
                SynchronizedObject.methodC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(15);
    }
}

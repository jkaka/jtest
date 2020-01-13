package com.kaka.jtest.jdk.model;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/01/13 21:25:10
 */
public class SynchronizedObject {

    public synchronized void methodA() throws InterruptedException {
        System.out.println("methodA...");
        TimeUnit.SECONDS.sleep(10);
    }

    public synchronized void methodB() throws InterruptedException {
        System.out.println("methodB...");

        TimeUnit.SECONDS.sleep(10);
    }

    public static synchronized void methodC() throws InterruptedException {
        System.out.println("methodC...");
        TimeUnit.SECONDS.sleep(10);
    }

    public static synchronized void methodD() throws InterruptedException {
        System.out.println("methodC...");
        TimeUnit.SECONDS.sleep(10);
    }
}

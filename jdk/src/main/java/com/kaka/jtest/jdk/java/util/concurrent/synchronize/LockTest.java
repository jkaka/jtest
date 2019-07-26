package com.kaka.jtest.jdk.java.util.concurrent.synchronize;

import com.kaka.jtest.jdk.java.util.concurrent.ThreadPoolTest;

import java.util.concurrent.TimeUnit;

/**
 * @author: jsk
 * @date: 2019/6/13 15:41
 */
public class LockTest {
    private static int num = 10;
    public synchronized void lockNum1() throws Exception {
        System.out.println(Thread.currentThread().getName() + "进入同步方法");
        num ++;
        System.out.println(Thread.currentThread().getName() + "********" + num);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            LockTest lockTest = new LockTest();
            ThreadPoolTest.execute(() ->{
                try {
                    lockTest.lockNum1();
                    System.out.println(Thread.currentThread().getName() + "执行结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        ThreadPoolTest.shutdown();
    }
}

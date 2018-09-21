package com.kaka.jtest.jdk.java.util.concurrent;

/**
 * @author jsk
 * @Date 2018/9/15 10:38
 */
public class VolatileTask implements Runnable {
    private volatile int volatileCount;
    private int commonCount;

    /**
     * i++ 不是原子操作,volatile不能解决原子问题
     */
    @Override
    public void run() {
        while (volatileCount == commonCount) {
            volatileCount++;
            commonCount++;
            System.out.println(Thread.currentThread().getName() + "--------v:" + volatileCount + "c:" + commonCount);
        }
        System.out.println(Thread.currentThread().getName() + "出现了！v:" + volatileCount + "c:" + commonCount);
    }
}

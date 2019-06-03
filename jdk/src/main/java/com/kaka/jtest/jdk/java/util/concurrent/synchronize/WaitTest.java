package com.kaka.jtest.jdk.java.util.concurrent.synchronize;

import org.junit.Test;

/**
 * @author: jsk
 * @date: 2019/5/29 20:34
 */
public class WaitTest {
    private Integer num = 0;

    @Test
    public void waitTest() {
        this.get();
    }

    public synchronized void get() {
        while (num >= 10) {
            System.out.println("产品已满！");
            try {
                this.wait();// 当多个生产者在等待时，每个生产者被唤醒时都再去判断一下产品的数量
            } catch (InterruptedException e) {
            }
        }
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + " : " + ++num);
    }

}

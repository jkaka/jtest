package com.kaka.jtest.jdk.java.util.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在for循环内,用while判断是否轮到该线程输出
 * 不该就什么都不做,直接释放锁
 *
 * @author jsk
 * @Date 2019/2/18 15:31
 */
public class PrintAbcLock {
    /**
     * 通过JDK5中的Lock锁来保证线程的访问的互斥
     */
    private static Lock lock = new ReentrantLock();
    /**
     * 通过state的值来确定是否打印
     */
    private static int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    // 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                    while (state % 3 == 0) {
                        System.out.print("A");
                        state++;
                        i++;
                    }
                } finally {
                    // unlock()操作必须放在finally块中
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state % 3 == 2) {
                        System.out.print("C");
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}

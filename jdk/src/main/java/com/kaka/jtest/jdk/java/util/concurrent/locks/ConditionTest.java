package com.kaka.jtest.jdk.java.util.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jsk
 * @Date 2019/2/18 15:11
 */
public class ConditionTest {
    private static Lock lock = new ReentrantLock();
    private static Condition oddCondition = lock.newCondition();
    private static Condition evenCondition = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (count < 100) {
                try {
                    lock.lock();
                    if (count % 2 == 1) {
                        // oddCondition释放lock
                        oddCondition.await();
                    }
                    if(count < 100){
                        System.out.println(Thread.currentThread().getName() + ":" + ++count);
                        // oddCondition执行完成唤醒evenCondition
                        evenCondition.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (count < 100) {
                try {
                    lock.lock();
                    if (count % 2 == 0) {
                        // evenCondition释放lock
                        evenCondition.await();
                    }
                    if(count < 100){
                        System.out.println(Thread.currentThread().getName() + ":" + ++count);
                        // evenCondition执行完成唤醒oddCondition
                        oddCondition.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }
}

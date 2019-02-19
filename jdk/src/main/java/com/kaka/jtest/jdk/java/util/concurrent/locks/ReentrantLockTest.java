package com.kaka.jtest.jdk.java.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jsk
 * @Date 2019/2/18 14:02
 */
public class ReentrantLockTest {

    private static int number = 0;

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        // 1.公平锁测试
        reentrantLockTest.fairTest();


    }

    /**
     * 公平
     */
    public void fairTest(){
        FairTest fairTest = new FairTest();
        Thread threadA = new Thread(fairTest, "a线程");
        Thread threadB = new Thread(fairTest, "b线程");

        threadA.start();
        threadB.start();
    }

    class FairTest implements Runnable{
        /**
         * 公平锁对象
         */
        final Lock lock = new ReentrantLock(true);

        @Override
        public void run() {
            while (number < 100) {
                try {
                    lock.lock();
                    // 二次判断
                    if(number < 100){
                        number++;
                        System.out.println(Thread.currentThread().getName() + ":" + number);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class CommunicationTest implements Runnable{
        /**
         * 锁对象
         */
        final Lock lock = new ReentrantLock();

        /**
         * 奇数线程条件
         */
        final Condition odd = lock.newCondition();
        /**
         * 偶数线程条件
         */
        final Condition even = lock.newCondition();

        @Override
        public void run() {
            while (number < 100) {
                try {
                    lock.lock();
                    if(number < 100){
                        number++;
                        System.out.println(Thread.currentThread().getName() + ":" + number);
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

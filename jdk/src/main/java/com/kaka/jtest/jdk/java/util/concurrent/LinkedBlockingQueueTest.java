package com.kaka.jtest.jdk.java.util.concurrent;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: jsk
 * @date: 2019/4/29 17:06
 */
public class LinkedBlockingQueueTest {

    /**
     * add：超出容量报错
     * 对应remove,没有元素时报错
     */
    @Test
    public void add() {
        BlockingQueue<String> objects = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            boolean aa = objects.add("aa");
            System.out.println(aa);
        }
    }

    @Test
    public void remove() {
        BlockingQueue<String> objects = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            System.out.println("remove元素:" + objects.remove());
        }
    }

    /**
     * offer(提供)：超出容量丢弃后面的元素,返回false
     * 对应poll(得到)：没有元素时,返回null
     */
    @Test
    public void offer() {
        BlockingQueue<String> objects = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            System.out.println("offer元素个数:" + (i + 1) + ";返回值:" + objects.offer("aa" + i));
        }
    }

    @Test
    public void poll() {
        BlockingQueue<String> objects = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            System.out.println("poll元素:" + objects.poll());
        }
    }

    /**
     * put：超出容量阻塞
     * 对应take(拿、取)
     */
    @Test
    public void put() throws InterruptedException {
        BlockingQueue<String> objects = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            objects.put("aa");
            System.out.println("put元素个数:" + (i + 1));
        }
    }

    @Test
    public void take() throws InterruptedException {
        BlockingQueue<String> objects = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            System.out.println("take元素:" + objects.take());
        }
    }

    /**
     * 剩余容量
     *
     * @throws InterruptedException
     */
    @Test
    public void remainingCapacityTest() throws InterruptedException {
        BlockingQueue<String> objects = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            objects.put("aa");
            System.out.println("remainingCapacity:" + objects.remainingCapacity());
        }
    }
}

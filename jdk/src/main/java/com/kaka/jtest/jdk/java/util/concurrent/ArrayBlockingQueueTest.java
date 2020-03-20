package com.kaka.jtest.jdk.java.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/19 21:21:27
 */
public class ArrayBlockingQueueTest {

    /**
     * 队列满之后，put()方法阻塞
     *
     * @throws InterruptedException
     */
    @Test
    public void put() throws InterruptedException {
        BlockingQueue<String> objects = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 100; i++) {
            objects.put("aa");
            System.out.println("put元素个数:" + (i + 1));
        }
        System.out.println(objects);
    }

    @Test
    public void take(){
    }
}

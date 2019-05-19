package com.kaka.jtest.jdk.java.util.concurrent;

/**
 * Executors各个方法的弊端：
 * 1）newFixedThreadPool和newSingleThreadExecutor:
 *   主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
 * 2）newCachedThreadPool和newScheduledThreadPool:
 *   主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
 *
 * @author: jsk
 * @date: 2019/4/29 17:00
 */
public class ExecutorsTest {
}

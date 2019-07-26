package com.kaka.jtest.jdk.java.util.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: jsk
 * @date: 2019/6/12 14:58
 */
public class ThreadPoolTest {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;

    static {
        // 获取处理器数量
        int cpuNum = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU数量:" + cpuNum);
        // 根据cpu数量,计算出合理的线程并发数
        int threadNum = cpuNum * 2 + 1;

        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(threadNum,// 核心线程数
                threadNum,// 最大线程数
                Integer.MAX_VALUE,// 当线程空闲时，线程存活时间
                TimeUnit.MILLISECONDS,// 时间单位
                new LinkedBlockingDeque<>(200),// 线程任务队列
                Executors.defaultThreadFactory(),// 线程工厂
                new ThreadPoolExecutor.AbortPolicy() {// 队列已满,而且当前线程数已经超过最大线程数时的异常处理策略
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                        super.rejectedExecution(r, e);
                    }
                }
        );
    }

    public static void execute(Runnable runnable) {
        THREAD_POOL_EXECUTOR.execute(runnable);
    }

    /**
     * 从线程队列中移除对象
     */
    public static void cancel(Runnable runnable) {
        if (THREAD_POOL_EXECUTOR != null) {
            THREAD_POOL_EXECUTOR.getQueue().remove(runnable);
        }
    }

    public static void shutdown() {
        THREAD_POOL_EXECUTOR.shutdown();
    }

}

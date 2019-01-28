package com.kaka.jtest.jdk.java.util.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2018/9/15 10:34
 */
public class VolatileTest {

    private static volatile boolean stopRequested;
    public boolean stop = false;

    /**
     * 测试内存可见性:while(非volatile字段)
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                // while(**)会被优化成:if(**) while(true)只判断一次
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        // ==========================================================
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.visibilityTest();
    }


    /**
     * 测试内存可见性     jdk1.8测试了N次,一直可见
     */
    public void visibilityTest() {
        VolatileTest volatileTest = new VolatileTest();
        // 线程1循环输出
        Thread thread = new Thread(() -> {
            while (true) {
                if (volatileTest.stop) {
                    System.out.println("------------------");
                    break;
                }
            }
        });

        // 线程2  修改stop的值
        Thread thread2 = new Thread(() -> {
            System.out.println("*****************************");
            volatileTest.stop = true;
        });

        thread.start();
        thread2.start();
    }

    @Test
    public void test() throws InterruptedException {
        VolatileTask volatileTask = new VolatileTask();
        ThreadManager.getInstance().execute(volatileTask);
        ThreadManager.getInstance().execute(volatileTask);
        TimeUnit.SECONDS.sleep(5);
        ThreadManager.getInstance().shutdown();
    }
}

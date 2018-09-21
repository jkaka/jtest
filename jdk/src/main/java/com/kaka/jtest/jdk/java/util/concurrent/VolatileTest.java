package com.kaka.jtest.jdk.java.util.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2018/9/15 10:34
 */
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        VolatileTask volatileTask = new VolatileTask();
        ThreadManager.getInstance().execute(volatileTask);
        ThreadManager.getInstance().execute(volatileTask);
        TimeUnit.SECONDS.sleep(5);
        ThreadManager.getInstance().shutdown();
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

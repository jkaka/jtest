package com.kaka.jtest.jdk.java.util.concurrent;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author jsk
 * @Date 2018/12/18 14:03
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(()-> System.out.println("AAAAAAA"),2,TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("BB:" + new Date()),2,3,TimeUnit.SECONDS);
    }
}

package com.kaka.jtest.jdk.java.util;

import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Timer是jdk中提供的一个定时器工具，使用的时候会在主线程之外起一个单独的线程执行指定的计划任务，可以指定执行一次或者反复执行多次。
 *
 * @author jsk
 * @Date 2018/12/18 13:53
 */
public class TimerTest {

    private static TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println("timer任务执行体！" + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {


        // 1.新建定时任务
        System.out.println("新建一个任务执行体...");

        // 2.启动定时任务
        System.out.println("启动定时任务...");
        Timer timer = new Timer("oneTimer");

        // 延迟 delay 执行并每隔period 执行一次
        long delay = 5000;
        long period = 3000;
        timer.schedule(timerTask, delay, period);

    }

    @Test
    public void cancelTest() throws InterruptedException {
        Timer timer = new Timer("oneTimer");
        timer.schedule(timerTask, 100, 2000);
        TimeUnit.SECONDS.sleep(20);
    }

    /**
     * schedule VS. scheduleAtFixedRate
     * 这两个方法都是任务调度方法，他们之间区别是，schedule会保证任务的间隔是按照定义的period参数严格执行的，如果某一次调度时间比较长，
     * 那么后面的时间会顺延，保证调度间隔都是period,而scheduleAtFixedRate是严格按照调度时间来的，如果某次调度时间太长了，
     * 那么会通过缩短间隔的方式保证下一次调度在预定时间执行。举个栗子：你每个3秒调度一次，那么正常就是0,3,6,9s这样的时间，如果第二次调度花了2s的时间，
     * 如果是schedule，就会变成0,3+2,8,11这样的时间，保证间隔，而scheduleAtFixedRate就会变成0,3+2,6,9，压缩间隔，保证调度时间。
     *
     * @throws InterruptedException
     */
    @Test
    public void scheduleAtFixedRateTest() throws InterruptedException {
        Timer timer = new Timer("atFixedRate");
        timer.scheduleAtFixedRate(timerTask, 100, 2000);
        TimeUnit.SECONDS.sleep(20);
    }

}

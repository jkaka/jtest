package com.kaka.jtest.jdk.java.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author jsk
 * @Date 2018/12/18 13:53
 */
public class TimerTest {


    public static void main(String[] args) {
        // 1.新建定时任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer任务执行体！" + new Date());
            }
        };

        // 延迟 delay 执行并每隔period 执行一次
        long delay = 5000;
        long period = 3000;

        // 2.启动定时任务
        Timer timer = new Timer("oneTimer");
        timer.schedule(timerTask, delay, period);
    }

    @Test
    public void tests(){
        int a = 6;
        Assert.assertTrue("ssss", a == 5);
    }

}

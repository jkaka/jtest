package com.kaka.jtest.springboot.biz.scheduler;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 需要在application主类加上@EnableScheduling注解
 *
 * @author jsk
 * @Date 2018/12/20 14:23
 */
@Component
@EnableAsync
@Async
public class ScheduleJobs {

    /**
     * 上一次调用结束后等待xx时间
     *
     * @throws InterruptedException
     */
//    @Scheduled(fixedDelay = 20 * 1000)
    public void fixedDelayJob() throws InterruptedException {
        // 1.查找出需要执行任务
        // 2.多线程去执行
        System.out.println(new Date() + "延迟20秒执行...");
    }

    /**
     * 上一次调用开始后等待xx时间
     *
     * @throws InterruptedException
     */
//    @Scheduled(fixedRate = 2 * 1000)
    public void fixedRateJob() throws InterruptedException {
        System.out.println(new Date() + "间隔秒执行开始..." + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
        System.out.println(new Date() + "间隔秒执行结束..." + Thread.currentThread().getName());
    }

//    @Scheduled(cron = "0/30 * * * * ?")
    public void cronJob() {
        System.out.println(new Date() + "每15秒执行...");
    }
}

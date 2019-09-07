package com.kaka.jtest.provider.client.service;

import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2019/2/26 10:52
 */
@Service
public class TimeOutServiceImpl implements TimeOutService {
    @Override
    public void sleepNum(int second) throws InterruptedException {
        System.out.println("调用提供者睡眠接口开始...");
        TimeUnit.SECONDS.sleep(second);
        System.out.println("调用提供者睡眠接口结束...");
    }
}

package com.kaka.jtest.provider.biz.service;

import com.kaka.jtest.api.client.service.TimeOutService;

import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2019/2/26 10:52
 */
public class TimeOutServiceImpl implements TimeOutService {
    @Override
    public void sleepFour() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
    }

    @Override
    public void sleepTwo() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public void sleepHalf() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
    }
}

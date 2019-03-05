package com.kaka.jtest.consumer.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kaka.jtest.api.client.service.TimeOutService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费方方法级 > 提供方方法级 > 消费方类级 > 提供方类级 > 消费方配置 > 提供方配置
 * 默认是1s
 *
 * @author jsk
 * @Date 2019/2/26 10:53
 */
@RestController
@RequestMapping("/timeOutController")
public class TimeOutController {
    @Reference(version = "1.0.0")
    private TimeOutService timeOutService;

    @RequestMapping("/sleepFour")
    public String sleepFour() throws InterruptedException {
        timeOutService.sleepFour();
        return "sleepFour";
    }

    @RequestMapping("/sleepTwo")
    public String sleepTwo() throws InterruptedException {
        timeOutService.sleepTwo();
        return "sleepTwo";
    }

    @RequestMapping("/sleepHalf")
    public String sleepHalf() throws InterruptedException {
        timeOutService.sleepHalf();
        return "sleepHalf";
    }
}

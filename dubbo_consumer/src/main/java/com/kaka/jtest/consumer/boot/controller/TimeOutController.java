package com.kaka.jtest.consumer.boot.controller;

import com.kaka.jtest.provider.client.service.TimeOutService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Reference
    private TimeOutService timeOutService;

    @RequestMapping("/sleep/{second}")
    public String sleepFour(@PathVariable Integer second) throws InterruptedException {
        timeOutService.sleepNum(second);
        return second + "";
    }
}

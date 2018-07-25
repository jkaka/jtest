package com.kaka.jtest.consumer.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kaka.jtest.api.client.service.UserReadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuangkaijia
 */
@RestController
public class DubboController {
    @Reference(version = "1.0.0")
    private UserReadService userReadService;

    @RequestMapping("/callA")
    public String callA() {
        System.out.println("调用A平台的Controller.callA()...");
        userReadService.selectAll();
        return "callA";
    }
}
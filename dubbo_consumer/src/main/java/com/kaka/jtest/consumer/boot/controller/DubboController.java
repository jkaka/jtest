package com.kaka.jtest.consumer.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kaka.jtest.api.client.service.UserReadService;
import com.kaka.jtest.consumer.call.UserCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuangkaijia
 */
@RestController
public class DubboController {

    @Autowired
    private UserCallService userCallService;
    @RequestMapping("/callA")
    public String callA() {
        System.out.println("调用A平台的Controller.callA()...");
        userCallService.selectAll();
        return "callA";
    }
}
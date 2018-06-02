package com.kaka.jtest.a.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kaka.jtest.api.client.service.UserWriteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuangkaijia
 */
@RestController()
public class DubboController {
    @Reference(version = "1.0.0", check = false)
    private UserWriteService userWriteService;

    @RequestMapping("/callB")
    public String callB() {
        System.out.println("调用B平台的Controller.callB()...");
        userWriteService.insert(null);
        return "callB";
    }
}

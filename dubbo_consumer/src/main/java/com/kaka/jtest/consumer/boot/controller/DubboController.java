package com.kaka.jtest.consumer.boot.controller;

import com.kaka.jtest.consumer.call.UserCallService;
import com.kaka.jtest.consumer.common.utils.TraceIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuangkaijia
 */
@RestController
@RequestMapping("/dubboController")
public class DubboController {

    @Autowired
    private UserCallService userCallService;

    @RequestMapping("/callA")
    public String callA() {

        System.out.println("调用A平台的Controller.callA()...");
        userCallService.selectAll();
        return "callA";
    }

    @RequestMapping("/dubboFilter")
    public String dubboFilter() {
        TraceIDUtil.setTraceId("测试通过dubboFilter传参！");
        System.out.println("测试通过dubboFilter传参！");
        userCallService.selectAll();
        return "dubboFilter";
    }
}
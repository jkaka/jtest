package com.kaka.jtest.consumer.boot.controller;

import com.kaka.common.utils.TraceIdUtil;
import com.kaka.jtest.api.client.service.UserReadService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuangkaijia
 */
@RestController
@RequestMapping("/dubboController")
public class DubboController {

    @Reference(version = "1.0.0")
    private UserReadService userReadService;

    @RequestMapping("/callA")
    public String callA() {

        System.out.println("调用A平台的Controller.callA()...");
        userReadService.selectAll();
        return "callA";
    }

    @RequestMapping("/selectOne")
    public String selectOne() {
        userReadService.selectOne(1);
        return "selectOne";
    }
    @RequestMapping("/dubboFilter")
    public String dubboFilter() {
        TraceIdUtil.setTraceId("测试通过dubboFilter传参！");
        System.out.println("测试通过dubboFilter传参！");
        userReadService.selectAll();
        return "dubboFilter";
    }

}
package com.kaka.jtest.consumer.boot.controller;

import com.kaka.common.utils.TraceIdUtil;
import com.kaka.jtest.provider.client.dto.UserDTO;
import com.kaka.jtest.provider.client.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shuangkaijia
 */
@RestController
@RequestMapping("/userController")
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping("/callA")
    public String callA() {
        RpcContext.getContext().setAttachment("request.tag", "tag3");
        RpcContext.getContext().setAttachment("requestTag", "tag5");
        System.out.println("调用A平台的Controller.callA()...");
        userService.selectAll();
        return "callA";
    }

    @RequestMapping("/selectOne")
    public UserDTO selectOne() {
        return userService.selectOne(1);
    }

    @RequestMapping("/selectAll")
    public List<UserDTO> selectAll() {
        return userService.selectAll();
    }

    @RequestMapping("/dubboFilter")
    public String dubboFilter() {
        TraceIdUtil.setTraceId("测试通过dubboFilter传参！");
        System.out.println("测试通过dubboFilter传参！");
        userService.selectAll();
        return "dubboFilter";
    }

}
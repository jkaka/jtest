package com.kaka.jtest.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuangkaijia
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/testSpringBoot")
    public String testSpringBoot(){
        System.out.println("Hello SpringBoot！");
        return "testSpringBoot";
    }
}

package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.biz.dataobject.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuangkaijia
 */
@Controller
@RequestMapping("/converterController")
public class ConverterController {

    /**
     * 自定义user
     * @param user
     */
    @ResponseBody
    @RequestMapping("/userCustom")
    public String userCustom(@RequestBody User user){
        System.out.println("5.controller:" + user);
        return "userCustom";
    }
}

package com.kaka.jtest.springboot.boot.controller;

import com.kaka.jtest.springboot.common.utils.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shuangkaijia
 */
@Controller
@RequestMapping("/logController")
public class LogController {
    private LogUtil logger = new LogUtil("jsk");
    @ResponseBody
    @RequestMapping("/getRequest")
    public String getRequest(){
        logger.info("controller方法...");
        return "getRequest";
    }
}

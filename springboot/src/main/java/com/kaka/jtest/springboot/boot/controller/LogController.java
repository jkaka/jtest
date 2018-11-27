package com.kaka.jtest.springboot.boot.controller;

import com.kaka.common.utils.LogUtil;
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
    private LogUtil loggerOther = new LogUtil(this.getClass());

    @ResponseBody
    @RequestMapping("/getRequest")
    public String getRequest() {
        logger.info("controller方法...");
        return "getRequest";
    }

    @ResponseBody
    @RequestMapping("/otherLog")
    public String otherLog() {
        loggerOther.info("测试jsessionId...");
        return "otherLog";
    }

    @ResponseBody
    @RequestMapping("/exceptionLog")
    public String exceptionLog() {
        Exception exception = new Exception("一个异常！");
        // 输出异常堆栈
        loggerOther.info("*****错误", exception);
        loggerOther.error("*****错误", exception);
        // 输出异常的全类名：异常信息
        loggerOther.error("*****错误" + exception);
        // 仅输出异常信息
        loggerOther.error("*****错误" + exception.getMessage());
        return "exceptionLog";
    }
}

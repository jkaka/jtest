package com.kaka.jtest.springmvc.controller;

import com.kaka.jtest.springmvc.common.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试异常的状态码
 *
 * @author: jsk
 * @date: 2019/8/20 16:22
 */
@RestController
@RequestMapping("/exceptionController")
public class ExceptionController {

    /**
     * 抛出子异常,声明基类异常;会交由@ExceptionHandler(MyException.class)去处理
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/throwMyException")
    public String throwJsonMappingException() throws Exception {
        if (1 == 1) {
            throw new MyException("999");
        }
        return "throwMyException";
    }
}

package com.kaka.jtest.springboot.boot.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试异常的状态码
 *
 * @author shuangkaijia
 */
@RestController
@RequestMapping("/exceptionController")
public class ExceptionController {

    @RequestMapping("/throwJsonMappingException")
    public String throwJsonMappingException() throws JsonMappingException {
        if (1 == 1) {
            throw new JsonMappingException("999");
        }
        return "throwJsonMappingException";
    }
}

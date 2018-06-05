package com.kaka.test.springboot.biz.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 *
 * @author shuangkaijia
 */
@RestControllerAdvice
public class HelloExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map operateExp(Exception ex, HttpServletRequest request) {
        System.out.println("全局异常处理器：出现了异常！" + ex.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 8500);
        map.put("msg", ex.getMessage());
        return map;
    }

}

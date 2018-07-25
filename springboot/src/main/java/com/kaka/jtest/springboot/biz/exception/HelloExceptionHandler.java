package com.kaka.jtest.springboot.biz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> operateExp(Exception ex, HttpServletRequest request) {
        logger.error("处理" + request.getRequestURI() + "请求系统异常,如下:", ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> map = new HashMap<>();
        map.put("code", 8500);
        map.put("msg", ex.getMessage());
        return new ResponseEntity(map, status);
    }
}

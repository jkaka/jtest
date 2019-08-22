package com.kaka.jtest.springmvc.biz.exception;

import com.kaka.jtest.springmvc.common.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 * @author: jsk
 * @date: 2019/8/20 16:23
 */
@RestControllerAdvice
public class MyExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> operateExp(Exception ex, HttpServletRequest request) {
        logger.error("处理" + request.getRequestURI() + "请求系统异常,如下:", ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> map = new HashMap<>();
        map.put("code", "Exception异常");
        map.put("msg", ex.getMessage());
        return new ResponseEntity(map, status);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> operateMyExp(Exception ex, HttpServletRequest request) {
        logger.error("处理" + request.getRequestURI() + "请求系统异常,如下:", ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> map = new HashMap<>();
        map.put("code", "MyException异常");
        map.put("msg", ex.getMessage());
        return new ResponseEntity(map, status);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> operateIOExp(IOException ex, HttpServletRequest request) {
        logger.error("处理"+request.getRequestURI()+"请求系统异常,如下:",ex);
        Map<String,String> json = new HashMap<String,String>();
        json.put("code", "123");
        json.put("message", "io");
        return new ResponseEntity(json, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

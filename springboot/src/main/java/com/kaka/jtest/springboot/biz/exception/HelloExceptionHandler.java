package com.kaka.jtest.springboot.biz.exception;

import com.kaka.jtest.springboot.common.model.BaseResult;
import com.kaka.jtest.springboot.common.utils.enums.ResultCode;
import com.kaka.jtest.springboot.common.utils.exception.KakaException;
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
 *
 * @author shuangkaijia
 */
@RestControllerAdvice
public class HelloExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(KakaException.class)
    public ResponseEntity<?> operateExp(Exception ex, HttpServletRequest request) {
        System.out.println("全局异常处理器：");
        logger.error("处理" + request.getRequestURI() + "请求系统异常,如下:", ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> map = new HashMap<>();
        map.put("code", 8500);
        map.put("msg", ex.getMessage());
        return new ResponseEntity(map, status);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> operateIOExp(IOException ex, HttpServletRequest request) {
        logger.error("处理"+request.getRequestURI()+"请求系统异常,如下:",ex);
        Map<String,String> json = new HashMap<String,String>();
        json.put("code",ResultCode.INTERNAL_SERVER_ERROR.getCode());
        json.put("message", ResultCode.INTERNAL_SERVER_ERROR.getName());
        return new ResponseEntity(json, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

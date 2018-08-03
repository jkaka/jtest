package com.kaka.jtest.springboot.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author shuangkaijia
 */
public class LogUtil {
    private Logger logger = null;

    private LogUtil() {

    }

    public LogUtil(String loggerName) {
        logger = LoggerFactory.getLogger(loggerName);
    }

    public LogUtil(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }


    public void error(String s) {
        if (logger.isErrorEnabled()) {
            logger.error(s);
        }
    }

    public void error(String s, Throwable e) {
        if (logger.isErrorEnabled()) {
            logger.error(s, e);
        }
    }

    public void info(String s) {
        String requestHeader = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("User-Agent");
        requestHeader = requestHeader == null ? "" : requestHeader;
        if (logger.isInfoEnabled()) {
            logger.info(requestHeader + s);
        }
    }

    public void info(String s, Throwable e) {
        if (logger.isInfoEnabled()) {
            logger.info(s, e);
        }
    }

    public void warn(String s) {
        if (logger.isWarnEnabled()) {
            logger.warn(s);
        }
    }

    public void warn(String s, Throwable e) {
        if (logger.isWarnEnabled()) {
            logger.warn(s, e);
        }
    }

    public void debug(String s) {
        if (logger.isDebugEnabled()) {
            logger.info(s);
        }
    }

    public void debug(String s, Throwable e) {
        if (logger.isDebugEnabled()) {
            logger.info(s, e);
        }
    }
}
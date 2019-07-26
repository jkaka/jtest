package com.kaka.jtest.openutils.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.slf4j.spi.LocationAwareLogger;


/**
 * @author: jsk
 * @date: 2019/6/27 21:35
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
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.ERROR.toInt(), s, null, null);
        }
    }

    public void error(String s, Throwable e) {
        if (logger.isErrorEnabled()) {
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.ERROR.toInt(), s, null, e);
        }
    }

    public void info(String s) {
        if (logger.isInfoEnabled()) {
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.INFO.toInt(), s, null, null);
        }
    }

    public void info(String s, Throwable e) {
        if (logger.isInfoEnabled()) {
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.INFO.toInt(), s, null, e);
        }
    }

    public void warn(String s) {
        if (logger.isWarnEnabled()) {
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.WARN.toInt(), s, null, null);
        }
    }

    public void warn(String s, Throwable e) {
        if (logger.isWarnEnabled()) {
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.WARN.toInt(), s, null, e);
        }
    }

    public void debug(String s) {
        if (logger.isDebugEnabled()) {
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.DEBUG.toInt(), s, null, null);
        }
    }

    public void debug(String s, Throwable e) {
        if (logger.isDebugEnabled()) {
            ((LocationAwareLogger) logger).log(null, LogUtil.class.getName(), Level.DEBUG.toInt(), s, null, e);
        }
    }
}

package com.kaka.jtest.openutils.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author jsk
 * @Date 2019/1/8 12:04
 */
public class LoggerTest {

//    private LogUtil logger = new LogUtil(LoggerTest.class);
    private LogUtil logger = new LogUtil("jsk");

    private Logger asyncLogger = LoggerFactory.getLogger("asyncLog");

    public LoggerTest() throws Exception {
    }

    @Test
    public void testParentLogger(){
        logger.info("日志000");

        MDC.put("car_model", "kc-2");
        logger.info("日志001");
        logger.info("日志002");

        MDC.put("car_model", "lyco-2");
        logger.info("日志003", new RuntimeException());
    }

    @Test
    public void asyncLogger(){
        asyncLogger.info("999999");
    }

    @Test
    public void infoObjects(){
        asyncLogger.info("999999", "333");
    }
}

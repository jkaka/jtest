package com.kaka.jtest.openutils.slf4j;

import org.junit.Test;
import org.slf4j.MDC;

/**
 * @author jsk
 * @Date 2019/1/8 12:04
 */
public class LoggerTest {

//    private LogUtil logger = new LogUtil(LoggerTest.class);
    private LogUtil logger = new LogUtil("jsk");

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

}

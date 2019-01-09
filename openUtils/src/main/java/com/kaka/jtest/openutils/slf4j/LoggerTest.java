package com.kaka.jtest.openutils.slf4j;

import org.junit.Test;

/**
 * @author jsk
 * @Date 2019/1/8 12:04
 */
public class LoggerTest extends BaseLogger {

    @Test
    public void testParentLogger(){
        logger.info("*************");
    }

}

package com.kaka.jtest.openutils.apache.logging.log4j.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * 在apache.logging包下的是log4j2
 *
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-18 15:15
 */
public class LoggerTest {
    private static Logger logger = LogManager.getLogger(LoggerTest.class.getName());

    @Test
    public void info() {
        logger.info("8888");
    }
}

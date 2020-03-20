package com.kaka.jtest.openutils.springframework.util;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/14 10:40:48
 */
public class StopWatchTest {

    @Test
    public void start() throws InterruptedException {
        StopWatch sw = new StopWatch("test");
        sw.start("task1");
        // do something
        Thread.sleep(100);
        sw.stop();
        sw.start("task2");
        // do something
        Thread.sleep(200);
        sw.stop();
        System.out.println("sw.prettyPrint()~~~~~~~~~~~~~~~~~");
        System.out.println(sw.prettyPrint());
    }
}

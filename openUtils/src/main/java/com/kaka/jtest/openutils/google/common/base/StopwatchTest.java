package com.kaka.jtest.openutils.google.common.base;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/13 17:16:19
 */
public class StopwatchTest {

    @Test
    public void elapsed() throws InterruptedException {
        Stopwatch started = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(1);
        long elapsed = started.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("花费时间为:" + elapsed + "ms");
    }
}

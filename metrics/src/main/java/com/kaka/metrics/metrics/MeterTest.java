package com.kaka.metrics.metrics;

import com.alibaba.metrics.Meter;
import com.alibaba.metrics.MetricManager;
import com.alibaba.metrics.MetricName;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author: jsk
 * @date: 2019/8/30 15:48
 */
public class MeterTest {

    @Test
    public void markTest() throws Exception {
        Meter methodMeter = MetricManager.getMeter("test", MetricName.build("myapp.mybiz.hello"));
        for (int i = 0; i < 100; i++) {
            // your logic
            methodMeter.mark();
            TimeUnit.MILLISECONDS.sleep(100);
        }
        System.out.println(methodMeter.getCount());
        System.out.println(methodMeter.getOneMinuteRate());
    }
}

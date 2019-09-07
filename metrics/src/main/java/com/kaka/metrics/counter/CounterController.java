package com.kaka.metrics.counter;

import com.alibaba.metrics.Counter;
import com.alibaba.metrics.MetricManager;
import com.alibaba.metrics.MetricName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jsk
 * @date: 2019/8/30 16:02
 */
@RestController
@RequestMapping("/counterController")
public class CounterController {
    private Counter myCounter = MetricManager.getCounter("test",
            MetricName.build("myapp.mybiz.hello.queue"));

    @GetMapping("/inc/{num}")
    public String inc(@PathVariable Integer num) {
        for (int i = 0; i < num; i++) {
            myCounter.inc();
        }
        return "inc";
    }

    @GetMapping("/dec/{num}")
    public String dec(@PathVariable Integer num) {
        for (int i = 0; i < num; i++) {
            myCounter.dec();
        }
        return "dec";
    }

}

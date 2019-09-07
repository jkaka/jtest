package com.kaka.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: jsk
 * @date: 2019/8/30 10:40
 */
@SpringBootApplication
public class MetricsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetricsApplication.class, args);
        Bootstrap.init();
    }
}

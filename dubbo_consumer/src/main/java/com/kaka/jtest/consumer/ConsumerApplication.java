package com.kaka.jtest.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuangkaijia
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.kaka.jtest.consumer.boot.controller")
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

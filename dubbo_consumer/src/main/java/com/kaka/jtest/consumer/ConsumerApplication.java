package com.kaka.jtest.consumer;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shuangkaijia
 */
@SpringBootApplication
@DubboComponentScan(basePackages = {"com.kaka.jtest.consumer.boot.controller", "com.kaka.jtest.consumer.biz.filter.dubbo"})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

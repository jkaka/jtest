package com.kaka.jtest.springboot.biz.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner类似于spring下的ApplicationListener
 * Order的值越小，优先级越高
 *
 * @author shuangkaijia
 */
@Order(1)
@Component
public class TestRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("springboot启动完成！");
    }
}

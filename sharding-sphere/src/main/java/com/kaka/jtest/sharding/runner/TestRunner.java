package com.kaka.jtest.sharding.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * boot启动之后执行
 *
 * @author shuangkaijia
 */
@Component
public class TestRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("springboot启动完成！");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("runner...结束");
    }
}
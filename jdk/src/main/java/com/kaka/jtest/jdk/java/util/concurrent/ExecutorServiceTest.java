package com.kaka.jtest.jdk.java.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * @author jiashuangkai
 * @date 2019/12/28 14:01:58
 */
public class ExecutorServiceTest {

    @Test
    public void submit() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                System.out.println("异步执行开始");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("异步执行结束");
                return "success";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "failed";
        });
        String result = future.get();
        System.out.println("执行结束：" + result);
    }

}

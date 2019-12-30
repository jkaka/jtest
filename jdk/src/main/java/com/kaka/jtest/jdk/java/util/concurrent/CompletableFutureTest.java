package com.kaka.jtest.jdk.java.util.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

/**
 * 注意：如果每个操作都很简单的话，没有必要用这种多线程异步的方式，因为创建线程还需要时间，还不如直接同步执行来得快。
 *
 * @author jiashuangkai
 * @date 2019/12/23 19:15:44
 */
public class CompletableFutureTest {

    /**
     * 异步执行  无返回值
     */
    @Test
    public void runAsync() {
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 异步执行  有回值
     */
    @Test
    public void supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "success");
        System.out.println(stringCompletableFuture.get());
        System.out.println("主线程名称:" + Thread.currentThread().getName());
    }

    @Test
    public void thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 99)
            .thenApply(num -> num + 10);
        System.out.println(integerCompletableFuture.get());
    }
}

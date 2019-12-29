package com.kaka.jtest.jdk.java.util.concurrent;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

/**
 * @author jiashuangkai
 * @date 2019/12/23 19:15:44
 */
public class CompletableFutureTest {

    @Test
    public void runAsync(){
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(Thread.currentThread().getName());
    }
}

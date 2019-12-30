package com.kaka.jtest.jdk.java.lang;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: jsk
 * @date: 2019/8/23 21:26
 */
public class ThreadLocalTest {
    public static final ThreadLocal<String> USER_NAME = new ThreadLocal<>();
    public static final ThreadLocal<String> USER_SCORE = new ThreadLocal<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            USER_NAME.set("jsk");
            USER_SCORE.set("99");
        });
        System.out.println(voidCompletableFuture.get());

        USER_NAME.set("hjq");
        USER_SCORE.set("66");
    }


}

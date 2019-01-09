package com.kaka.jtest.jdk.java.test.callback;

import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2018/12/3 14:24
 */
public class AsyncHandler implements Runnable {
    private EventCallback eventCallback;

    public AsyncHandler(EventCallback eventCallback) {
        this.eventCallback = eventCallback;
    }

    @Override
    public void run() {
        System.out.println("远程服务开始执行...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("远程服务执行成功...");
        eventCallback.run();
    }
}

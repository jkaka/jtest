package com.kaka.jtest.jdk.java;

import java.util.concurrent.TimeUnit;

public class APP {

    public static void main(String[] args) throws InterruptedException {
        Thread loadConfigThread = new Thread(() -> {
            while (true){
                System.out.println("888999");
            }
        });

        Thread loadConfigThread1 = new Thread(() -> {
            while (true){
                System.out.println("111222");
            }
        });

        Thread loadConfigThread2 = new Thread(() -> {
            while (true){
                System.out.println("111222");
            }
        });


        loadConfigThread.start();
        loadConfigThread1.start();
        loadConfigThread2.start();

        TimeUnit.SECONDS.sleep(10);
    }

}

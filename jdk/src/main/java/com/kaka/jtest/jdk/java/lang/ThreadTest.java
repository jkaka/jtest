package com.kaka.jtest.jdk.java.lang;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author shuangkaijia
 */
public class ThreadTest {
    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("111");
            /*try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("线程已中断");
            }*/
            System.out.println("222");
        });
        thread.start();
        thread.interrupt();
        TimeUnit.SECONDS.sleep(115);
//        thread.start();
    }
}

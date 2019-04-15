package com.kaka.jtest.jdk.java.util.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2018/9/15 10:34
 */
public class VolatileTest {

    private static volatile boolean stopRequested;
    private static boolean finished;
    public boolean stop = false;

    /**
     * 测试内存可见性:while(非volatile字段)
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        while (true){
            if(threadDemo.isFlag()){
                System.out.println("******************");
                break;
            }
            System.out.println(threadDemo.isFlag());
        }
    }
    static class ThreadDemo implements  Runnable{
        private  boolean flag = false;

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println(isFlag());
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }


    /**
     * 测试内存可见性     jdk1.8测试了N次,一直可见
     */
    public void visibilityTest() {
        VolatileTest volatileTest = new VolatileTest();
        // 线程1循环输出
        Thread thread = new Thread(() -> {
            while (true) {
                if (volatileTest.isStop()) {
                    System.out.println("状态改变,程序结束!");
                    break;
                }
                System.out.println("888888888");
            }
        });

        // 线程2  修改stop的值
        Thread thread2 = new Thread(() -> {
            System.out.println("*****************************");
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volatileTest.setStop(true);
        });

        thread.start();
        thread2.start();
    }

    @Test
    public void test() throws InterruptedException {
        VolatileTask volatileTask = new VolatileTask();
        ThreadManager.getInstance().execute(volatileTask);
        ThreadManager.getInstance().execute(volatileTask);
        TimeUnit.SECONDS.sleep(5);
        ThreadManager.getInstance().shutdown();
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}

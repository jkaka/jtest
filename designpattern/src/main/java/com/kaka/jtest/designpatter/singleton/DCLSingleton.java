package com.kaka.jtest.designpatter.singleton;

/**
 * double checked locking
 *
 * @author: jsk
 * @date: 2019/8/23 21:15
 */
public class DCLSingleton {

    /**
     * 1. 一定要有volatile关键字修饰
     */
    private volatile static DCLSingleton uniqueInstance;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (uniqueInstance == null) {
            // 2. 给当前类加锁,而不是this
            synchronized (DCLSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DCLSingleton();
                }
            }
        }
        return uniqueInstance;
    }

    void getConnection() {
        System.out.println("dcl方式的单例...");
    }
}

package com.kaka.jtest.designpatter.singleton;

/**
 * 懒汉式,使用双重检查保证线程安全、高效
 *
 * @author: jsk
 * @date: 2019/6/29 14:37
 */
public class IdlerSingleton {
    private volatile static IdlerSingleton uniqueInstance;

    private IdlerSingleton() {
    }

    /**
     * 懒汉式使用同步方式
     *
     * @return
     */
    public static synchronized IdlerSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new IdlerSingleton();
        }
        return uniqueInstance;
    }

    void getConnection() {
        System.out.println("懒汉式的单例...");
    }
}

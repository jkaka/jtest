package com.kaka.jtest.designpatter.singleton;

/**
 * 懒汉式,使用双重检查保证线程安全、高效
 *
 * @author: jsk
 * @date: 2019/6/29 14:37
 */
public class SingletonB {
    private volatile static SingletonB uniqueInstance;

    private SingletonB(){}
    public static SingletonB getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonB.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonB();
                }
            }
        }
        return uniqueInstance;
    }
}

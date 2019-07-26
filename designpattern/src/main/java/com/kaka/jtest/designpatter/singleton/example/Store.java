package com.kaka.jtest.designpatter.singleton.example;

import com.kaka.jtest.designpatter.singleton.SingletonB;

/**
 * @author: jsk
 * @date: 2019/6/29 14:48
 */
public class Store {
    private volatile static Store uniqueInstance;

    private final String storeName;

    private Store() {
        System.out.println("第一次有人访问商店,开始执行创建...");
        this.storeName = "峡谷商店:" + System.currentTimeMillis();
    }

    /**
     * 使用双重检查保证线程安全、高效
     *
     * @return
     */
    public static Store getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonB.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Store();
                }
            }
        }
        return uniqueInstance;
    }

    public String getStoreName() {
        return storeName;
    }
}

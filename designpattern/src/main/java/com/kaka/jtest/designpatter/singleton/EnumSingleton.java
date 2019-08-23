package com.kaka.jtest.designpatter.singleton;

/**
 * @author: jsk
 * @date: 2019/8/23 21:07
 */
public enum EnumSingleton {
    INSTANCE;

    void getConnection() {
        System.out.println("枚举方式的单例...");
    }
}

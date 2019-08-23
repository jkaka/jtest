package com.kaka.jtest.designpatter.singleton;

/**
 * 饿汉式
 * 依赖jvm在加载这个类时马上创建此唯一的单件实例
 * 也可以去掉访问该变量的方法,直接把全局变量置为public
 *
 * @author: jsk
 * @date: 2019/6/29 14:42
 */
public class BadMashSingleton {
    private BadMashSingleton() {
    }

    private static BadMashSingleton uniqueInstance = new BadMashSingleton();

    public static BadMashSingleton getInstance() {
        return uniqueInstance;
    }

    void getConnection() {
        System.out.println("饿汉式的单例...");
    }
}

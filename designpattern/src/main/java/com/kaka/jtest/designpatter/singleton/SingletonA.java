package com.kaka.jtest.designpatter.singleton;

/**
 * 饿汉式
 * 依赖jvm在加载这个类时马上创建此唯一的单件实例
 *
 * @author: jsk
 * @date: 2019/6/29 14:42
 */
public class SingletonA {
    private SingletonA() {
    }

    private static SingletonA uniqueInstance = new SingletonA();

    public static SingletonA getInstance() {
        return uniqueInstance;
    }
}

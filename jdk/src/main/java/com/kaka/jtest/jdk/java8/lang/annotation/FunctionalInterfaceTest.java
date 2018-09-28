package com.kaka.jtest.jdk.java8.lang.annotation;

/**
 * 函数接口,使用@FunctionalInterface注解标识
 * 只有一个抽象方法的接口
 *
 * @author shuangkaijia
 */
@FunctionalInterface
public interface FunctionalInterfaceTest {
    void apply();

    /**
     *  常用函数接口：Supplier调用get()方法；Predicate，调用test()方法；Function，调用apply()方法。
     */
}

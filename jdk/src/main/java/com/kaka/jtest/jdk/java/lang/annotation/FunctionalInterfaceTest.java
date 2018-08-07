package com.kaka.jtest.jdk.java.lang.annotation;

/**
 * 函数接口,使用@FunctionalInterface注解标识
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

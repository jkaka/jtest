package com.kaka.jtest.jdk.java.grammar.interface0;

/**
 * java8的新语法中,可以在接口中定义默认方法和静态方法
 *
 * @author jsk
 * @Date 2018/8/15 14:03
 */
public interface InterfaceTest {
    /**
     * 默认方法是指接口中定义的包含方法体的方法，方法名有 default 关键字做前缀。
     */
    default void defaultMethod() {
        System.out.println("接口中的默认方法！");
    }

    static void staticMethod() {
        System.out.println("接口中的静态方法！");
    }
}

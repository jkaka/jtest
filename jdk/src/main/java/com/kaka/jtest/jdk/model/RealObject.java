package com.kaka.jtest.jdk.model;

/**
 * @author shuangkai.jia
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething...");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse..." + arg);
    }
}

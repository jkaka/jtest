package com.kaka.jtest.designpatter.proxy;

/**
 * @author: jsk
 * @date: 2019/8/3 11:26
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("实际对象的request方法...");
    }
}

package com.kaka.jtest.jdk.java.lang.reflect;

import com.kaka.jtest.jdk.model.Interface;
import com.kaka.jtest.jdk.model.RealObject;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void main(String[] args) {
        RealObject realObject = new RealObject();

        // 创建代理对象
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject));
        // 调用代理对象的方法时，会重定向到第三个参数(实现InvocationHandler接口)的invoke方法中
        // 在invoke方法中，再调用真实对象的对应方法。
        proxy.doSomething();
    }
}

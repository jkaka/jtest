package com.kaka.jtest.designpatter.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: jsk
 * @date: 2019/8/3 11:27
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Subject subject;

    public ProxyInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理拦截方法:" + method.getName());
        return method.invoke(subject, args);
    }

    public Subject getSubjectProxy(){
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        return (Subject) Proxy.newProxyInstance(classLoader, interfaces, this);
    }
}

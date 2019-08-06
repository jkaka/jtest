package com.kaka.jtest.designpatter.proxy;

/**
 * @author: jsk
 * @date: 2019/8/3 11:36
 */
public class ProxyClient {
    public static void main(String[] args) {
        Subject subject = new RealSubject();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler(subject);
        Subject subjectProxy = proxyInvocationHandler.getSubjectProxy();

        subjectProxy.request();
    }
}

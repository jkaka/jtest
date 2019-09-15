package com.kaka.spring.pojo;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author: jsk
 * @date: 2019/9/15 16:38
 */
public class ReplaceMethodBean implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("我是一个汪星人...");
        return null;
    }
}

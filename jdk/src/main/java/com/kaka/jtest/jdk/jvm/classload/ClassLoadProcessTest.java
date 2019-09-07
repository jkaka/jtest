package com.kaka.jtest.jdk.jvm.classload;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author: jsk
 * @date: 2019/9/3 16:07
 */
public class ClassLoadProcessTest {

    @Test
    public void loadMethodTest() throws Exception {
        Class<?> aClass = Class.forName("com.kaka.jtest.jdk.jvm.classload.MyObject");
        Object newInstance = aClass.newInstance();
        Method method1 = aClass.getDeclaredMethod("method1");
        method1.invoke(newInstance);
    }
}

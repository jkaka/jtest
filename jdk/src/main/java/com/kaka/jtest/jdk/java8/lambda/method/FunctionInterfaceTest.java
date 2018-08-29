package com.kaka.jtest.jdk.java8.lambda.method;


import com.kaka.jtest.jdk.model.Person;

/**
 * 函数接口
 *
 * @author jsk
 * @Date 2018/8/29 9:41
 */
@FunctionalInterface
public interface FunctionInterfaceTest {
    String getUserName(Person person);
}

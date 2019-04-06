package com.kaka.jtest.jdk.java8.lambda.method;

import com.kaka.jtest.jdk.model.Person;

/**
 * @author jsk
 * @Date 2018/8/29 9:52
 */
@FunctionalInterface
public interface LambdaNewObj extends FunctionInterfaceTest {
    @Override
    default String getUserName(Person person) {
        return "... from side to side";
    }

    Person create(Integer id, String name);
}

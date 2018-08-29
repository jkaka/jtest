package com.kaka.jtest.jdk.java8.lambda.method;

import com.kaka.jtest.jdk.model.Person;

/**
 * @author jsk
 * @Date 2018/8/29 11:20
 */
@FunctionalInterface
public interface LambdaNewArray extends FunctionInterfaceTest  {
    @Override
    default String getUserName(Person person) {
        return "... from side to side";
    }

    Person[] create(int length);
}

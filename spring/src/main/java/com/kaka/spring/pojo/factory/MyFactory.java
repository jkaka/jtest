package com.kaka.spring.pojo.factory;

import com.kaka.spring.pojo.Person;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/22 15:51:11
 */
public class MyFactory {

    public static Person staticMethod(String name, Integer age){
        System.out.println("静态工厂方法");
        return new Person(name, age);
    }

    public Person factoryMethod(String name, Integer age){
        System.out.println("普通工厂方法");
        return new Person(name, age);
    }
}

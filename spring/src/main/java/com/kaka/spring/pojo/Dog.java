package com.kaka.spring.pojo;

/**
 * @author: jsk
 * @date: 2019/9/15 16:25
 */
public class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("汪汪");
    }
}

package com.kaka.spring.pojo;

/**
 * @author: jsk
 * @date: 2019/9/15 16:26
 */
public class Cat implements Animal {
    @Override
    public void say() {
        System.out.println("喵喵...");
    }
}

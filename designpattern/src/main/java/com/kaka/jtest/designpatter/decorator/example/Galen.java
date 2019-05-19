package com.kaka.jtest.designpatter.decorator.example;

/**
 * @author: jsk
 * @date: 2019/5/12 17:30
 */
public class Galen implements Hero {

    @Override
    public Integer healthPoint() {
        return 3000;
    }

    @Override
    public String description() {
        return "我是盖伦";
    }
}

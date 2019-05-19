package com.kaka.jtest.designpatter.decorator.example;

/**
 * 基础组件类
 * @author: jsk
 * @date: 2019/5/12 17:24
 */
public interface Hero {
    /**
     * 生命值
     * @return
     */
    Integer healthPoint();

    String description();
}

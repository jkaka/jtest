package com.kaka.jtest.designpatter.builder;

/**
 * @author: jsk
 * @date: 2019/8/10 15:19
 */
public class Director {
    private AbstractBuilder builder;

    // 可以使用构造方法、setter方式注入builder对象
    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    public Product construct() {
        // 构造过程
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        // 返回构造结果
        return builder.getResult();
    }
}

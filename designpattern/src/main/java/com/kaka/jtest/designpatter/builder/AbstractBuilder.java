package com.kaka.jtest.designpatter.builder;

/**
 * @author: jsk
 * @date: 2019/8/10 11:52
 */
public abstract class AbstractBuilder {
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    /**
     * 获取构造后的产品
     *
     * @return
     */
    public Product getResult() {
        return product;
    }
}

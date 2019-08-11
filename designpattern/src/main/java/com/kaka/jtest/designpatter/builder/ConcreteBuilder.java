package com.kaka.jtest.designpatter.builder;

/**
 * @author: jsk
 * @date: 2019/8/10 15:18
 */
public class ConcreteBuilder extends AbstractBuilder{

    @Override
    public void buildPartA() {
        product.setPartA("A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("C");
    }
}
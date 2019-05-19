package com.kaka.jtest.designpatter.decorator;

/**
 * 装饰者A实现类
 *
 * @author: jsk
 * @date: 2019/5/11 22:00
 */
public class ConcreteDecoratorA extends AbstractDecorator {
    public ConcreteDecoratorA(Component component) {
        this.component = component;
    }
    @Override
    public String methodA() {
        return component.methodA() + ", 加一颗糖";
    }

    @Override
    public Integer methodB() {
        return component.methodB() + 10;
    }
}

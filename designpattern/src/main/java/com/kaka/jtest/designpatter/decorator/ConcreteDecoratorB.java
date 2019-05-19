package com.kaka.jtest.designpatter.decorator;

/**
 * @author: jsk
 * @date: 2019/5/11 22:00
 */
public class ConcreteDecoratorB extends AbstractDecorator {
    public ConcreteDecoratorB(Component component) {
        this.component = component;
    }
    @Override
    public String methodA() {
        return component.methodA() + ", 加二两奶油";
    }

    @Override
    public Integer methodB() {
        return component.methodB() + 8;
    }
}

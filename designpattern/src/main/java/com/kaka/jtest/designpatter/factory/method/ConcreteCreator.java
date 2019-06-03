package com.kaka.jtest.designpatter.factory.method;

/**
 * 具体的创建器对象，覆盖实现Creator定义的工厂方法，返回具体的Product实例
 * @author: jsk
 * @date: 2019/5/25 17:50
 */
public class ConcreteCreator extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProduct();
    }
}

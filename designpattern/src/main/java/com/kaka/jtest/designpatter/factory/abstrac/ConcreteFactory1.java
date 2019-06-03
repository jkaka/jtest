package com.kaka.jtest.designpatter.factory.abstrac;

/**
 * 具体工厂实现不同产品家族。
 * 要创建一个产品，客户端只要使用其中的一个工厂而完全不需要实例化任何产品对象
 *
 * @author: jsk
 * @date: 2019/5/25 20:02
 */
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        System.out.println("工厂1,正在创建产品A");
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        System.out.println("工厂1,正在创建产品B");
        return new ProductB1();
    }
}

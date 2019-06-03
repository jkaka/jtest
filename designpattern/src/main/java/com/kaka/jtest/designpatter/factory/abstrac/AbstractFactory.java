package com.kaka.jtest.designpatter.factory.abstrac;

/**
 * 抽象工厂定义了一个接口，所有的具体工厂都必须实现此接口，这个接口包含一组方法用来生产产品
 * @author: jsk
 * @date: 2019/5/25 19:59
 */
public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

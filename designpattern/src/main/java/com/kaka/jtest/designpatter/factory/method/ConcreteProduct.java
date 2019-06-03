package com.kaka.jtest.designpatter.factory.method;

/**
 *具体的Product接口的实现对象
 * @author: jsk
 * @date: 2019/5/25 17:47
 */
public class ConcreteProduct implements Product {
    @Override
    public void sayHello() {
        System.out.println("工厂方法,创建出来的产品...");
    }
}

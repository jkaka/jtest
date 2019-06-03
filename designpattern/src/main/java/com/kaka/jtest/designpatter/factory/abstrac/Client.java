package com.kaka.jtest.designpatter.factory.abstrac;

/**
 * @author: jsk
 * @date: 2019/5/25 20:06
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        abstractFactory.createProductA();
        abstractFactory.createProductB();
    }
}

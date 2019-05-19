package com.kaka.jtest.designpatter.decorator;

/**
 * @author: jsk
 * @date: 2019/5/11 22:04
 */
public class Main {
    public static void main(String[] args) {
        // 1.创建一个需要装饰的对象
        ConcreteComponent concreteComponent = new ConcreteComponent();

        // 2.创建两个装饰者对象
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(concreteComponent);
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);

        // 3.执行
        System.out.println("组合结果:" + concreteDecoratorB.methodA());
        System.out.println("总费用:" + concreteDecoratorB.methodB());
    }
}

package com.kaka.jtest.designpatter.template;

/**
 * @author: jsk
 * @date: 2019/7/14 16:50
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public void primitiveOperation2() {
        System.out.println("子类必须实现的方法2");
    }
}

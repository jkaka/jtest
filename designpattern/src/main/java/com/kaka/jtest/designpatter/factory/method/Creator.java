package com.kaka.jtest.designpatter.factory.method;

/**
 * 创建器，声明工厂方法，工厂方法通常会返回一个Product类型的实例对象，而且多是抽象方法。也可以在Creator里面提供工厂方法的默认实现，
 * 让工厂方法返回一个缺省的Product类型的实例对象。
 * @author: jsk
 * @date: 2019/5/25 17:50
 */
public abstract class Creator {
    abstract Product factoryMethod();
    void anOperation(){
        Product product = factoryMethod();
        product.sayHello();
    }
}

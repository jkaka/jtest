package com.kaka.jtest.designpatter.builder;

/**
 * @author: jsk
 * @date: 2019/8/10 15:20
 */
public class DirectorClient {
    public static void main(String[] args) {
        AbstractBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}

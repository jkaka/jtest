package com.kaka.jtest.designpatter.factory.method;

/**
 * @author: jsk
 * @date: 2019/5/25 17:50
 */
public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        creator.anOperation();
    }
}

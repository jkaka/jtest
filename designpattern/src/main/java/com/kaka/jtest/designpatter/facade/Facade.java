package com.kaka.jtest.designpatter.facade;

/**
 * @author: jsk
 * @date: 2019/7/13 14:49
 */
public class Facade {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public Facade(SystemA systemA, SystemB systemB, SystemC systemC) {
        this.systemA = systemA;
        this.systemB = systemB;
        this.systemC = systemC;
    }

    public void test1() {
        systemA.method1();
        systemB.method1();
        systemC.method1();
    }

    public void test2() {
        systemA.method2();
        systemB.method2();
        systemC.method2();
    }

    public static void main(String[] args) {
    }
}

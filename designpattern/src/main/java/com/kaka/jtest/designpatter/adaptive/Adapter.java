package com.kaka.jtest.designpatter.adaptive;

/**
 * @author: jsk
 * @date: 2019/7/13 12:27
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

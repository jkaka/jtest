package com.kaka.jtest.designpatter.adaptive;

/**
 * @author: jsk
 * @date: 2019/7/13 12:35
 */
public class Client {
    public static void main(String[] args) {
        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}

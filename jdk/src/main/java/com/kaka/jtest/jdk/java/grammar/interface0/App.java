package com.kaka.jtest.jdk.java.grammar.interface0;

/**
 * @author jsk
 * @Date 2018/8/13 9:36
 */
public class App {
    public static void main(String[] args) {
        Parent parent = new ParentImpl();
        parent.welcome();
        System.out.println(parent.getLastMessage());

        Child child = new ChildImpl();
        child.welcome();
        System.out.println(child.getLastMessage());

    }
}

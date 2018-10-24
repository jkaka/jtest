package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.model.Person;
import com.kaka.jtest.jdk.model.Student;

public class ObjectTest {
    private static Student student = new Student();
    static {
        System.out.println("静态代码块...");
    }

    private Person person = new Person();
    {
        System.out.println("普通代码块...");
        person.getId();
    }

    public ObjectTest() {
        System.out.println("object....");person.getId();
    }

    static void staticMethod() {
        System.out.println("staticMethod...");
    }

    /**
     * 创建对象执行顺序
     * 1.静态代码块和静态域，按声明顺序仅执行一次。
     * 2.代码块和非静态变量域，按声明顺序在对象每次创建之前执行。
     * 3.构造方法
     * 4.静态方法、普通方法在调用的时候才执行。
     *
     * 代码块和变量域执行顺序，跟声明顺序有关
     * 除了构造方法,其他方法都是在被调用时执行
     * 注意：构造方法中可以引用全局变量,跟声明顺序无关。是因为，构造方法执行的时候，变量域一定是已经执行完成了。
     *
     * @param args
     */
    public static void main(String[] args) {
        new ObjectTest();
        new ObjectTest();
    }
}

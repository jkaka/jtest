package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.model.Person;

public class ObjectTest {

    private Person person = new Person();
    private String name = person.getName();

    public ObjectTest() {
        System.out.println("object....");
    }
}

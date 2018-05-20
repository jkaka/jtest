package com.kaka.jtest.jdk.java.lang.entities;

public class Person {

    private Integer id = 1;
    private String name = "AA";

    public Person() {
        System.out.println("创建了一个person....");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

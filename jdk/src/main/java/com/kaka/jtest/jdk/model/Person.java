package com.kaka.jtest.jdk.model;

public class Person {
    private Integer id;
    private String name;

    public Person() {
        System.out.println("创建了一个Person...");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Integer id, String name) {
        System.out.println("创建了一个：" + name);
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person getPersonByName(String name){
        return new Person(666, name);
    }

    public Integer getAgeByName(String name){
        return 55;
    }
}

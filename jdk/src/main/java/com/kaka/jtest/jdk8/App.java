package com.kaka.jtest.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    @Test
    public void testLambda() {
        Person person1 = new Person(1, "AA");
        Person person2 = new Person(2, "BB");
        Person person3 = new Person(0, "CC");
        Person person4 = new Person(4, "DD");

        List<Person> list = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));
        list.stream().filter(person -> person.getId() > 0)
                .forEach((person) -> {
                    System.out.println(person);
                });
    }

    @Test
    public void testLambda1() {
        sout((s)->System.out.println("" + s));
    }

    private void sout(TestInterface testInterface){
        testInterface.test("abc");
    }
}

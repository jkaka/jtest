package com.kaka.jtest.jdk.java;

import com.kaka.jtest.jdk.java.model.Person;
import org.junit.Test;

import java.util.List;

public class APP {

    @Test
    public void test1() {
        List<Person> list = null;
        list.stream().filter(task ->
                null != task.getId()
                        && task.getId() < System.currentTimeMillis()
        )
                .forEach((task) -> {
                    System.out.println("---");
                    task.setName("offline");
                    System.out.println(task);
                });

    }

}

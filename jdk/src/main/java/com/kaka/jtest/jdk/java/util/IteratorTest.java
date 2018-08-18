package com.kaka.jtest.jdk.java.util;

import com.kaka.jtest.jdk.java.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    /**
     * 外部迭代(从集合中一个个的取出来，然后一个个的处理；内部迭代是在集合中直接处理完成)
     */
    @Test
    public void outIterator() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "AA"));
        personList.add(new Person(2, "BB"));
        personList.add(new Person(3, "CC"));

        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            // 返回cursor位置的元素，并让cursor+1
            Person person = iterator.next();
            System.out.println("id:" + person.getId() + "，name:" + person.getName());
        }
        personList.stream();

    }
}

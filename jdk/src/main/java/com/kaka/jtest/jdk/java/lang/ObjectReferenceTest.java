package com.kaka.jtest.jdk.java.lang;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jsk
 * @date: 2019/9/18 14:55
 */
public class ObjectReferenceTest {
    /**
     * 给引用赋值
     */
    @Test
    public void assignment() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person("person");
        String string = "string";
        assignmntToList(personList, person, string);
        System.out.println(personList);
        System.out.println(person);
        System.out.println(string);
    }

    /**
     * 给引用赋值
     *
     * @param personList
     * @param person
     * @param string
     */
    private void assignmntToList(List<Person> personList, Person person, String string) {
        // personList指向了一个新的地址,原来地址中的内容未改变
        // 实参中引用地址值不会改变,所以assignment中的personList还是原来的值
        personList = Arrays.asList(new Person("AA"),
                new Person("BB"));
        // person指向了一个新的地址
        person = new Person("test");
        string = "abc";
    }
}

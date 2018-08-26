package com.kaka.jtest.jdk.java.grammar;

import com.kaka.jtest.jdk.java.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 方法引用
 *
 * @author jsk
 * @Date 2018/8/22 9:54
 */
public class MethodTest {

    /**
     * 方法引用
     * artist -> artist.getName()  的简写 Artist::getName
     */
    @Test
    public void methodQuote() {
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "aa"), new Person(2, "bb")));
        List<String> personNames = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(personNames);
    }
}

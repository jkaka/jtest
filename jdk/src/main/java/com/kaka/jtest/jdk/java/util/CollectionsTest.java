package com.kaka.jtest.jdk.java.util;

import com.kaka.jtest.jdk.java.model.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author jsk
 * @Date 2018/8/13 10:21
 */
public class CollectionsTest {

    @Test
    public void sort() {
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person(1, "CA"), new Person(2, "BB"), new Person(3, "CC")));
        System.out.println(personList);
        Collections.sort(personList, Comparator.comparing(Person :: getName));
        System.out.println(personList);
    }
}

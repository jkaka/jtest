package com.kaka.jtest.jdk.java8.util;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/9/28 9:05
 */
public class MapTest {

    /**
     * map中key对应的值不存在时，使用该 Lambda 表达式计算新值
     * 用途：定制缓存，没有命中再去库中读取
     */
    @Test
    public void computeIfAbsentTest() {
        Map<String, Person> map = new HashMap<>();
        map.put("AA", new Person(1, "AA"));
        map.put("BB", new Person(2, "BB"));
        map.computeIfAbsent("CC", key -> new Person().getPersonByName(key));
        System.out.println(map);
    }

    /**
     * compute：结合原key，value计算新值
     */
    @Test
    public void computeTest() {
        Map<String, Person> map = new HashMap<>();
        map.put("AA", new Person(1, "AA"));
        map.put("BB", new Person(2, "BB"));
        map.compute("CC", (key, person) -> {
            if (person == null) {
                return new Person().getPersonByName(key);
            } else {
                return person.getPersonByName(key);
            }
        });
        System.out.println(map);
    }

    /**
     * map的forEach遍历
     */
    @Test
    public void forEachTest() {
        Map<String, Person> map = new HashMap<>();
        map.put("AA", new Person(1, "AA"));
        map.put("BB", new Person(2, "BB"));
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }
}
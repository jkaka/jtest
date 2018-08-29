package com.kaka.jtest.jdk.java.util;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    /**
     * 测试list的remove(Object o)方法
     */
    @Test
    public void removeObject() {
        List<String> strings = new ArrayList<>();
        System.out.println(strings.remove("a"));
    }

    /**
     * 自身循环时删除元素：使用foreach
     */
    @Test
    public void removeInForeach() {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c", "b"));
        for (String str : strings) {
            if (str.equals("b")) {
                strings.remove(str);
            }
        }
        System.out.println(strings);
    }

    /**
     * 自身循环时删除元素：使用iterator
     */
    @Test
    public void removeInIterator() {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c", "b"));
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("b")) {
                iterator.remove();
            }
        }
        System.out.println(strings);
    }

    @Test
    public void removeIndex() {
        List<String> strings = new ArrayList<>();
        System.out.println(strings.remove(1));
    }

    /**
     * 把list声明为final，依然可以添加item
     */
    @Test
    public void testFinal() {
        final List<String> strings = new ArrayList<>();
        System.out.println(strings.size());
        strings.add("AAa");
        System.out.println(strings.size());
    }

    /**
     * 泛型转换
     */
    @Test
    public void genericity() {
        Object list = new ArrayList<Person>(Arrays.asList(new Person(1, "AA")));
        List<String> one = (List<String>) list;
        System.out.println(one.size());
        // 当取出元素的时候，会把list中的对象转换为String
        System.out.println(one.get(0));
    }

    @Test
    public void addNull() {
        List<String> strings = new ArrayList<>();
        strings.add(null);
        System.out.println(strings.size());
    }
}

package com.kaka.jtest.jdk.java.util;

import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author: jsk
 * @date: 2019/4/9 18:05
 */
public class ArrayListTest {
    /**
     * 测试list的remove(Object o)方法
     */
    @Test
    public void removeObject() {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "a"));
        System.out.println(strings.remove("a"));
        System.out.println(strings);
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

    @Test
    public void foreachTest() {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c", "b"));
        strings.forEach(s -> System.out.println("8888"));
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
        Object list = new ArrayList<>(Collections.singletonList(new Person(1, "AA")));
        List<String> one = (List<String>) list;
        System.out.println(one.size());
        // 当取出元素的时候，会把list中的对象转换为String
        System.out.println(one.get(0));
    }

    @Test
    public void addNull() {
        List<String> strings = new ArrayList<>();
        strings.add(null);
        strings.add(null);
        System.out.println(strings.size());
    }

    /**
     * 修改引用的对象,list中的对象就会改变
     */
    @Test
    public void updateReference() {
        List<Person> personList = Arrays.asList(new Person(1, "AA"), new Person(2, "BB"));
        Person person = personList.get(1);
        person.setName("BB00");
        System.out.println(personList);
    }

    @Test
    public void sortTest() {
        List<Person> personList = Arrays.asList(new Person(1, "AA", 2),
                new Person(3, "BB", 1),
                new Person(2, "BB", 3));
        personList.sort(Comparator.comparing(Person::getAge));
        System.out.println(personList);

        personList.sort((p1, p2) -> p1.getAge()>p2.getAge() ? 1 : -1);
        System.out.println(personList);
    }
}

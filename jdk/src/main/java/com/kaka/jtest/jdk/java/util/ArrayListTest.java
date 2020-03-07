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
     * 三个初始化方法
     */
    @Test
    public void constructMethod() {
        List<String> strings1 = new ArrayList<>();
        List<String> strings2 = new ArrayList<>(21);
        List<String> strings3 = new ArrayList<>(Arrays.asList("a", "b", "a"));
        System.out.println(strings1);
        System.out.println(strings2);
        System.out.println(strings3);
    }

    /**
     * DEFAULTCAPACITY_EMPTY_ELEMENTDATA和EMPTY_ELEMENTDATA时add扩容大小区别
     */
    @Test
    public void constructMethodInt() {
        List<String> strings1 = new ArrayList<>();
        List<String> strings2 = new ArrayList<>(0);
        strings1.add("a");
        strings2.add("a");
        System.out.println(strings1);
        System.out.println(strings2);
    }

    /**
     * 测试代码中的toArray
     * {@link java.util.ArrayList#ArrayList(java.util.Collection)}
     */
    @Test
    public void constructCodeToArray() {
        Object[] objects = returnTest();
        objects[4] = "aa";
        objects[5] = new Object();
        System.out.println(Arrays.toString(objects));
    }

    /**
     * 声明返回值为Object[]  实际返回String[]
     *
     * @return
     */
    private Object[] returnTest() {
        return new String[10];
    }

    /**
     * toArray方法可能返回String[]
     */
    @Test
    public void constructCodeToArrayTest() {
        List<String> asList = Arrays.asList("asList", "aa");
        Object[] asListArray = asList.toArray();
        System.out.println(asListArray.getClass());
        System.out.println(Arrays.toString(asListArray));
    }

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
     * 在foreach中删除元素会报错:ConcurrentModificationException
     */
    @Test
    public void removeInForeach() {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c", "b"));
        for (String str : strings) {
            if ("b".equals(str)) {
                strings.remove(str);
            }
        }
        System.out.println(strings);
    }

    /**
     * 使用迭代器的remove方法,即可正常删除
     */
    @Test
    public void removeSuccess() {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c", "b"));
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if ("b".equals(str)) {
                it.remove();
            }
        }
        System.out.println(strings);
    }

    /**
     * jdk 1.8的新方法
     */
    @Test
    public void removeIfTest() {
        List<String> strings = new ArrayList<>(Arrays.asList("a", "b", "c", "b"));
        strings.removeIf("b"::equals);
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
        List<String> one = (List<String>)list;
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

        personList.sort((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1);
        System.out.println(personList);
    }

    /**
     * 子列表包含fromIndex不包含toIndex
     */
    @Test
    public void subList() {
        List<Person> personList = Arrays.asList(
            new Person(1, "AA", 2),
            new Person(3, "BB", 1),
            new Person(2, "BB", 3));
        System.out.println(personList.subList(0, 2));
        System.out.println(personList.subList(0, 0));
    }
}

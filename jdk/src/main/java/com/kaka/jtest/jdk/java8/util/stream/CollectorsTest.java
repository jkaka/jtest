package com.kaka.jtest.jdk.java8.util.stream;


import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * 收集器
 *
 * @author jsk
 * @Date 2018/8/29 17:08
 */
public class CollectorsTest {

    private List<Person> personList;

    {
        Person person0 = new Person(null, "AA");
        Person person1 = new Person(5, null);
        Person person2 = new Person(6, "DD");
        Person person3 = new Person(7, "BB");
        Person person4 = new Person(8, "CC");
        personList = Arrays.asList(person0, person1, person2, person3, person4);
    }


    /**
     * 调用 toList 或者 toSet 方法时，不需要指定具体的类型。Stream 类库在背后自动为你
     * 挑选出了合适的类型(并行处理数据的情况)。
     */
    @Test
    public void collect() {
        Person person1 = new Person(1, "AA");
        Person person2 = new Person(2, "BB");
        List<String> collected = Stream.of(person1, person2)
                .map(Person::getName)
                .collect(toList());
        collected.stream()
                .collect(toList());
        collected.stream()
                .collect(Collectors.toSet());
        // 转换成指定类型的集合
        collected.stream()
                .collect(toCollection(TreeSet::new));
        System.out.println(collected);
    }

    /**
     * 收集stream中对象的最大值
     */
    @Test
    public void maxByTest() {
        Person person1 = new Person(16, "AA");
        Person person2 = new Person(2, "DD");
        Person person3 = new Person(5, "BB");
        Person person4 = new Person(6, "BB");
        Person person5 = new Person(2, "CC");
        Person person6 = new Person(16, "BB");
        Person person7 = new Person(10, "BB");
        Stream<Person> personList = Stream.of(person1, person2, person3, person4, person5, person6, person7);

        // 如果有两个最大值,取第一个
        Function<Person, Integer> maxIdFunction = Person::getId;
        Optional<Person> optionalPerson = personList.collect(maxBy(comparing(maxIdFunction)));
        if (optionalPerson.isPresent()) {
            System.out.println(optionalPerson.get());
        }
    }

    /**
     * 收集stream中对象的平均值
     */
    @Test
    public void averagingIntTest() {
        Person person1 = new Person(5, "AA");
        Person person2 = new Person(6, "DD");
        Person person3 = new Person(7, "BB");
        Stream<Person> personList = Stream.of(person1, person2, person3);
        // 返回值为double
        Double averageId = personList.collect(averagingInt(Person::getId));
        System.out.println(averageId);
    }

    /**
     * partitioningBy：分割成两个流
     * 使用 Predicate 对象作为分类器,将数据分成 true 和 false 两部分
     */
    @Test
    public void partitioningByTest() {
        Person person1 = new Person(5, "AA");
        Person person2 = new Person(6, "DD");
        Person person3 = new Person(7, "BB");
        Stream<Person> personList = Stream.of(person1, person2, person3);
        Map<Boolean, List<Person>> listMap = personList.collect(partitioningBy(person -> person.getId() > 5));
        System.out.println(listMap.get(false));
        System.out.println(listMap.get(true));
    }

    /**
     * groupingBy：把数据流分组
     * 数据分组:分类器是一个 Function 对象，根据属性值分组
     */
    @Test
    public void groupingByTest() {
        Person person0 = new Person(4, "AA");
        Person person1 = new Person(5, "AA");
        Person person2 = new Person(6, "DD");
        Person person3 = new Person(7, "BB");
        Stream<Person> personList = Stream.of(person0, person1, person2, person3);
        Map<String, List<Person>> listMap = personList.collect(groupingBy(Person::getName));
        System.out.println(listMap.get("AA"));
    }

    /**
     * 使用joining给map转换后的对象，加入分隔符（用以分隔元素）、前缀和后缀
     */
    @Test
    public void joiningTest() {
        Person person0 = new Person(4, "AA");
        Person person1 = new Person(5, "AA");
        Person person2 = new Person(6, "DD");
        Person person3 = new Person(7, "BB");
        Stream<Person> personList = Stream.of(person0, person1, person2, person3);
        String result = personList.map(Person::getName)
                .collect(Collectors.joining("-", "[", "]"));
        System.out.println(result);
    }


    /**
     * 下游收集器：counting
     * 收集name为AA的person个数
     */
    @Test
    public void countingTest() {
        Person person0 = new Person(4, "AA");
        Person person1 = new Person(5, "AA");
        Person person2 = new Person(6, "DD");
        Person person3 = new Person(7, "BB");
        Person person4 = new Person(7, "BB");
        Stream<Person> personList = Stream.of(person0, person1, person2, person3, person4);
        Map<String, Long> stringLongMap = personList.collect(groupingBy(Person::getName, counting()));
        System.out.println(stringLongMap.get("AA"));
    }

    /**
     * 下游收集器：mapping 在收集器的容器上执行类似 map 的操作
     * 收集name为AA的person的id列表
     */
    @Test
    public void mappingTest() {
        Person person0 = new Person(4, "AA");
        Person person1 = new Person(5, "AA");
        Person person2 = new Person(6, "DD");
        Person person3 = new Person(7, "BB");
        Person person4 = new Person(7, "BB");
        Stream<Person> personList = Stream.of(person0, person1, person2, person3, person4);
        Map<String, List<Integer>> stringListMap = personList.collect(groupingBy(Person::getName,
                mapping(Person::getId, toList())));
        System.out.println(stringListMap.get("AA"));
    }

    /**
     * key重复会报错    v为null也会报错
     * 对象中的属性为K、V
     */
    @Test
    public void toMapFieldTest() {
        Map<Integer, String> map = personList.stream()
                .collect(toMap(Person::getId, Person::getName));
        System.out.println(map);
    }

    /**
     * key重复会报错
     * 属性为key   对象本身为V
     */
    @Test
    public void toMapThisTest() {
        Map<Integer, Person> map = personList.stream()
                .collect(toMap(Person::getId, person -> person));
        System.out.println(map);
    }

    /**
     * key重复会报错
     * 属性为key   对象本身为V(java8内置方法)
     */
    @Test
    public void toMapThisBuiltInTest() {
        Map<Integer, Person> map = personList.stream()
                .collect(toMap(Person::getId, Function.identity()));
        System.out.println(map);
    }

    /**
     * 指定key重复策略
     */
    @Test
    public void toMapRepetitionKeyTest() {
        Map<Integer, Person> map = personList.stream()
                .collect(toMap(Person::getId, Function.identity(), (key1, key2) -> key1));
        System.out.println(map);
    }

    /**
     * 指定key重复策略
     */
    @Test
    public void toMapCustomMapTest() {
        Map<Integer, Person> map = personList.stream()
                .collect(toMap(Person::getId, Function.identity(), (key1, key2) -> key1, LinkedHashMap::new));
        System.out.println(map);
    }

    /**
     * 解决v为null的情况,重载collect方法
     */
    @Test
    public void toMapCustomMapTest2() {
        Map<Integer, Person> map = personList.stream()
                .collect(HashMap::new, (m, v) -> m.put(v.getId(), v), HashMap::putAll);
        System.out.println(map);
    }
}

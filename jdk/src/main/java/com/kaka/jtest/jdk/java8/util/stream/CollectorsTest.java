package com.kaka.jtest.jdk.java8.util.stream;


import com.kaka.jtest.jdk.model.Person;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
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

}

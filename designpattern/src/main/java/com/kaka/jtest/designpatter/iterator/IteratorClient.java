package com.kaka.jtest.designpatter.iterator;

import java.util.UUID;

/**
 * @author: jsk
 * @date: 2019/7/20 16:55
 */
public class IteratorClient {
    public static void main(String[] args) {
        // 1.创建组合
        int personNum = 10;
        Person[] personArray = new Person[personNum];
        for (int i = 0; i < personNum; i++) {
            personArray[i] = new Person(UUID.randomUUID().toString(), i);
        }
        Aggregate<Person> aggregate = new ConcreteAggregate<>(personArray);

        // 2.创建迭代器
        Iterator<Person> iterator = aggregate.createIterator();
        while (iterator.hashNext()) {
            System.out.println(iterator.next());
        }
    }
}

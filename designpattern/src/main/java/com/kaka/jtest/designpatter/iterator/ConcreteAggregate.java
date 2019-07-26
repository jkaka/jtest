package com.kaka.jtest.designpatter.iterator;

/**
 * 具体的聚合类:只管对象集合的操作,迭代集合的工作交给iterator去关注
 *
 * @author: jsk
 * @date: 2019/7/20 16:39
 */
public class ConcreteAggregate<T> implements Aggregate<T> {
    private T[] personArray;

    public ConcreteAggregate(T[] personArray) {
        this.personArray = personArray;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<T>(personArray);
    }
}

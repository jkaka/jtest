package com.kaka.jtest.designpatter.iterator;

/**
 * 聚合接口
 *
 * @author: jsk
 * @date: 2019/7/20 16:36
 */
public interface Aggregate<T> {
    Iterator<T> createIterator();
}

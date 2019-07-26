package com.kaka.jtest.designpatter.iterator;

/**
 * @author: jsk
 * @date: 2019/7/20 16:37
 */
public interface Iterator<T> {
    boolean hashNext();
    T next();
    T remove();
}

package com.kaka.jtest.designpatter.iterator.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/20 17:14
 */
public interface MatchIterator {
    boolean hashNext();
    Match next();
    Match remove();
}

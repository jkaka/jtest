package com.kaka.jtest.designpatter.combination;

/**
 * @author: jsk
 * @date: 2019/7/26 11:49
 */
public interface Component {
    void operation(String string);
    boolean add(Component component);
    boolean remove(Component component);
    Component getChild(int i);
}

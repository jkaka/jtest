package com.kaka.jtest.designpatter.combination.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/27 13:14
 */
public abstract class FriendComponent {
    boolean add(FriendComponent friendComponent) {
        throw new UnsupportedOperationException();
    }

    boolean remove(FriendComponent friendComponent) {
        throw new UnsupportedOperationException();
    }

    FriendComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void print(String prefix);
}

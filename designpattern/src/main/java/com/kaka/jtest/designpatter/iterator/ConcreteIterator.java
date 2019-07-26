package com.kaka.jtest.designpatter.iterator;

/**
 * @author: jsk
 * @date: 2019/7/20 16:40
 */
public class ConcreteIterator<T> implements Iterator<T> {
    private T[] objectArray;
    private int position = 0;

    public ConcreteIterator(T[] objectArray) {
        this.objectArray = objectArray;
    }

    @Override
    public boolean hashNext() {
        if (position >= objectArray.length
                || objectArray[position] == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public T next() {
        T t = objectArray[position];
        position++;
        return t;
    }

    @Override
    public T remove() {
        return null;
    }
}

package com.kaka.spring.annotation.bean;

/**
 * @author: jsk
 * @date: 2019/3/21 22:54
 */
public class GenericityBean<T> {
    private Object[] list = new Object[10];
    private int offset = 0;

    public void add(T t){
        System.out.println(t);
        list[offset] = t;
        offset ++;
    }

    public T get(int i){
        return (T)list[i];
    }
}

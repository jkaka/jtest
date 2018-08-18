package com.kaka.jtest.jdk.java.grammar.interface0;

/**
 * @author jsk
 * @Date 2018/8/13 9:35
 */
public interface Child extends Parent {
    @Override
    default void welcome() {
        message("Child:Hi!(Child接口,重写后的默认方法)");
    }
}

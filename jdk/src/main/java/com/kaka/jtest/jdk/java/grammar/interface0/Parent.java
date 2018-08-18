package com.kaka.jtest.jdk.java.grammar.interface0;

/**
 * @author jsk
 * @Date 2018/8/13 9:31
 */
public interface Parent {
    void message(String body);
    default void welcome(){
        message("Patent:Hi!(Parent接口的默认方法！)");
    }
    String getLastMessage();
}

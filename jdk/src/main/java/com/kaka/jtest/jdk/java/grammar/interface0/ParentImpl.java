package com.kaka.jtest.jdk.java.grammar.interface0;

/**
 * @author jsk
 * @Date 2018/8/13 9:33
 */
public class ParentImpl implements Parent {
    private String message;
    @Override
    public void message(String body) {
        message = body;
    }

    @Override
    public String getLastMessage() {
        return message;
    }
}

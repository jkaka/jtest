package com.kaka.jtest.designpatter.command.example;

/**
 * @author: jsk
 * @date: 2019/7/6 16:56
 */
public interface Command {
    void execute();
    void undo();
}

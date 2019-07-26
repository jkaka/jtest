package com.kaka.jtest.designpatter.command;

/**
 * @author: jsk
 * @date: 2019/7/6 9:35
 */
public interface Command {
    void execute();
    void undo();
}

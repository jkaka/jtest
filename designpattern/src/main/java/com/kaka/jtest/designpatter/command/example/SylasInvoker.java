package com.kaka.jtest.designpatter.command.example;

/**
 * @author: jsk
 * @date: 2019/7/6 16:56
 */
public class SylasInvoker {
    private Command command;

    public void setSkillR(Command command) {
        this.command = command;
    }

    public void releaseR() {
        command.execute();
    }
}

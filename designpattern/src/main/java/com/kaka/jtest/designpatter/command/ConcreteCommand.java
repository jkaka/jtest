package com.kaka.jtest.designpatter.command;

/**
 * @author: jsk
 * @date: 2019/7/6 9:35
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }

    @Override
    public void undo() {

    }
}

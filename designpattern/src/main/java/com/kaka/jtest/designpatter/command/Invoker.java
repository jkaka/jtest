package com.kaka.jtest.designpatter.command;

/**
 * @author: jsk
 * @date: 2019/7/6 9:39
 */
public class Invoker {
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void button(){
        command.execute();
    }
}

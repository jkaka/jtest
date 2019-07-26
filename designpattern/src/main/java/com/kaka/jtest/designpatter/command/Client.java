package com.kaka.jtest.designpatter.command;

/**
 * @author: jsk
 * @date: 2019/7/6 9:33
 */
public class Client {
    public static void main(String[] args) {
        // 1.创建接收者
        Receiver receiver = new Receiver();

        // 2.使用命令对象封装接收者
        ConcreteCommand concreteCommand = new ConcreteCommand(receiver);

        // 3.把命令对象存入Invoker
        Invoker invoker = new Invoker();
        invoker.setCommand(concreteCommand);

        // 4.调用Invoker
        invoker.button();
    }
}

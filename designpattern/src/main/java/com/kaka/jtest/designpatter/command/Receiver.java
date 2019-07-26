package com.kaka.jtest.designpatter.command;

/**
 * 接收者知道如何进行必要的工作,实现这个请求。任何类都可以当接收者
 *
 * @author: jsk
 * @date: 2019/7/6 9:37
 */
public class Receiver {
    public void action() {
        System.out.println("打开电灯");
    }
}

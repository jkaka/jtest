package com.kaka.jtest.consumer.boot.controller;

import com.kaka.scheduler.task.DemoTask;

/**
 * @author jsk
 * @Date 2018/12/21 9:56
 */
public class DemoTaskkk extends DemoTask {
    @Override
    public void execute() {
        System.out.println("自定义方法");
    }
}

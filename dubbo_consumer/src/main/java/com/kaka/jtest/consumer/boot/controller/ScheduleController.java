package com.kaka.jtest.consumer.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kaka.scheduler.task.DemoTask;
import com.kaka.scheduler.task.TaskHandler;
import com.kaka.scheduler.task.TaskHandlerInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jsk
 * @Date 2018/12/20 15:51
 */
@RestController
@RequestMapping("/scheduleController")
public class ScheduleController implements Serializable {
    @Reference
    private TaskHandlerInterface taskHandler;

    @RequestMapping("/callBack")
    public String callBack(){
        Date date = new Date(System.currentTimeMillis() + 20 * 1000);
        taskHandler.schedule(date, new DemoTask() {
            @Override
            public void execute() {
                System.out.println("把A车更新为红色！");
            }
        });
        return "callBack";
    }
}

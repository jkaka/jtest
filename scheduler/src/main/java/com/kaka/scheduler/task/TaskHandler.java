package com.kaka.scheduler.task;


import com.alibaba.dubbo.config.annotation.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author jsk
 * @Date 2018/12/20 15:19
 */
@Service
public class TaskHandler implements TaskHandlerInterface{
    public TaskHandler() {
        System.out.println("创建taskHandler....");
    }

    public static Map<String, DemoTask> taskMap = new HashMap<>(32);

    @Override
    public void schedule(Date date, DemoTask demoTask) {
        System.out.println("微服务传过来的对象：" + demoTask);
        new Thread(() -> {
            demoTask.setScheduleTime(date);
            taskMap.put(UUID.randomUUID().toString(), demoTask);
        }).start();
    }
}

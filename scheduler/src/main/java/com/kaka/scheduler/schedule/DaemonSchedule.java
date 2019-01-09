package com.kaka.scheduler.schedule;

import com.kaka.scheduler.task.DemoTask;
import com.kaka.scheduler.task.TaskHandler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/12/20 15:11
 */
@Component
public class DaemonSchedule {

    /**
     * 上一次调用结束后等待xx时间
     *
     * @throws InterruptedException
     */
    @Scheduled(fixedDelay = 5 * 1000)
    public void fixedDelayJob() throws InterruptedException {
        // 1.查找出需要执行任务
        Map<String, DemoTask> taskMap = TaskHandler.taskMap;
        for(String taskId : taskMap.keySet()){
            DemoTask demoTask = taskMap.get(taskId);
            if(demoTask.getScheduleTime().getTime() > System.currentTimeMillis()){
                // 2.多线程去执行
                demoTask.execute();
            }
        }
    }
}

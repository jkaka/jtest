package com.kaka.jtest.tbschedule.scheduler;

import com.kaka.jtest.tbschedule.entities.HelloTask;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 多任务调度
 */
@Component("multiTaskScheduleTest")
public class MultiTaskScheduleTest implements IScheduleTaskDealMulti<HelloTask> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Comparator<HelloTask> getComparator() {
        return null;
    }

    @Override
    public List<HelloTask> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
                                       List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        logger.info("multiTaskScheduleTest多任务列表..........");
        List<HelloTask> helloTaskList = new ArrayList<HelloTask>();
        helloTaskList.add(new HelloTask(1, "task1"));
        helloTaskList.add(new HelloTask(2, "task2"));
        helloTaskList.add(new HelloTask(3, "task3"));
        logger.info("helloTaskList:" + helloTaskList);
        return helloTaskList;
    }

    @Override
    public boolean execute(HelloTask[] helloTasks, String ownSign) throws Exception {
        logger.info("多任务执行：" + new Date());
        logger.info("helloTasks:" + new ArrayList<HelloTask>(Arrays.asList(helloTasks)));
        return true;
    }
}
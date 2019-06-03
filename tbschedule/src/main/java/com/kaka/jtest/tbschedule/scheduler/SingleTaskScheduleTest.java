package com.kaka.jtest.tbschedule.scheduler;

import com.kaka.jtest.tbschedule.entities.HelloTask;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 单任务调度
 */
@Component("singleTaskScheduleTest")
public class SingleTaskScheduleTest implements IScheduleTaskDealSingle<HelloTask> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Comparator<HelloTask> getComparator() {
        return null;
    }

    @Override
    public List<HelloTask> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
                                       List<TaskItemDefine> taskItemList, int eachFetchDataNum, int pageNum) throws Exception {
        logger.info("singleTaskScheduleTest单任务列表..........");
        List<HelloTask> helloTaskList = new ArrayList<HelloTask>();
        helloTaskList.add(new HelloTask(1, "task1"));
        helloTaskList.add(new HelloTask(2, "task2"));
        helloTaskList.add(new HelloTask(3, "task3"));
        logger.info("helloTaskList:" + helloTaskList);
        return helloTaskList;
    }

    @Override
    public boolean execute(HelloTask helloTask, String ownSign) throws Exception {
        logger.info("单任务执行：" + new Date());
        logger.info("helloTask:" + helloTask);
        return true;
    }
}
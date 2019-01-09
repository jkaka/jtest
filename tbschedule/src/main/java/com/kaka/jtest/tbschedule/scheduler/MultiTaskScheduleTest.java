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
    private Integer pageIndex = 0;

    @Override
    public Comparator<HelloTask> getComparator() {
        return null;
    }

    /**
     * 根据条件，查询当前调度服务器可处理的任务
     *
     * @param taskParameter    任务的自定义参数
     * @param ownSign          当前环境名称
     * @param taskQueueNum     任务项的数量 (10个)
     * @param taskItemList     当前线程组中的任务队列 (每组一个队列)
     * @param eachFetchDataNum 每次获取数据的数量 500
     * @return
     * @throws Exception
     */
    @Override
    public List<HelloTask> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
                                       List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        logger.info(Thread.currentThread().getName() + "自定义参数:" + taskParameter);
        logger.info(Thread.currentThread().getName() + "ownSign:" + ownSign);
        logger.info(Thread.currentThread().getName() + "任务项的数量:" + taskQueueNum);
        logger.info(Thread.currentThread().getName() + "taskItemList:" + taskItemList);
        logger.info(Thread.currentThread().getName() + "每次获取数据的数量:" + eachFetchDataNum);
        Map<String, Object> param = new HashMap<>();
        // 如果一个队列分配到一个组中，这个循环只执行一次。
        for (TaskItemDefine taskItemDefine : taskItemList) {
            param.clear();
            // taskItemNum = 10
            param.put("factor", taskQueueNum);
            // residue = 0-9
            param.put("residue", taskItemDefine.getTaskItemId());
            // pageSize = 500
            param.put("pageSize", eachFetchDataNum);
        }
        List<HelloTask> helloTaskList = new ArrayList<HelloTask>();
//        if(++pageIndex != 3){
            logger.info(Thread.currentThread().getName() + "第" + pageIndex + "次执行此方法");
            helloTaskList.add(new HelloTask(1, "task1" + Thread.currentThread().getName()));
            helloTaskList.add(new HelloTask(2, "task2" + Thread.currentThread().getName()));
            helloTaskList.add(new HelloTask(3, "task3" + Thread.currentThread().getName()));
//        }
        return null;
    }

    @Override
    public boolean execute(HelloTask[] helloTasks, String ownSign) throws Exception {
        logger.info("线程：" + Thread.currentThread().getName() + "；正在处理helloTasks:" + new ArrayList<>(Arrays.asList(helloTasks)));
        return true;
    }
}
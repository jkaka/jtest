package com.kaka.jtest.tbschedule.scheduler;

import com.kaka.jtest.tbschedule.entities.HelloTask;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多任务调度
 */
@Component("multiTaskScheduleTest")
public class MultiTaskScheduleTest implements IScheduleTaskDealMulti<HelloTask> {

    private final Logger logger = LoggerFactory.getLogger("schedule");
    private AtomicInteger atomicInteger = new AtomicInteger(0);

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
                                       List<TaskItemDefine> taskItemList, int eachFetchDataNum, int pageNum) throws Exception {
        /*logger.info(Thread.currentThread().getName() + "自定义参数:" + taskParameter);
        logger.info(Thread.currentThread().getName() + "ownSign:" + ownSign);
        logger.info(Thread.currentThread().getName() + "任务项的数量:" + taskQueueNum);
        logger.info(Thread.currentThread().getName() + "taskItemList:" + taskItemList);
        logger.info(Thread.currentThread().getName() + "每次获取数据的数量:" + eachFetchDataNum);*/
        logger.info("************************************" + pageNum);
        logger.info(Thread.currentThread().getName() + "开始获取任务...");
        logger.info(Thread.currentThread().getName() + "taskItemList:" + taskItemList);
        /*Map<String, Object> param = new HashMap<>();
        // 如果一个队列分配到一个组中，这个循环只执行一次。
        for (TaskItemDefine taskItemDefine : taskItemList) {
            param.clear();
            // taskItemNum = 10
            param.put("factor", taskQueueNum);
            // residue = 0-9
            param.put("residue", taskItemDefine.getTaskItemId());
            // pageSize = 500
            param.put("pageSize", eachFetchDataNum);
        }*/
        List<HelloTask> helloTaskList = new ArrayList<HelloTask>();
        if (atomicInteger.intValue() < 10) {
            logger.info(Thread.currentThread().getName() + "第" + atomicInteger.incrementAndGet() + "次执行此方法");
            helloTaskList.add(new HelloTask(1, "task1" + Thread.currentThread().getName()));
            helloTaskList.add(new HelloTask(2, "task2" + Thread.currentThread().getName()));
            helloTaskList.add(new HelloTask(3, "task3" + Thread.currentThread().getName()));
        }else{
            atomicInteger.set(0);
            return null;
        }
        return helloTaskList;
    }

    /**
     * 每次执行数量：tbs会将selectTasks()返回的List均分到每个线程；多线程情况下,A线程获取的任务不一定都由A线程处理。
     * 下次获取任务(selectTasks方法)，总发生在execute处理完成之后。(多线程也是如此，未处理完成之前，不会有线程去查任务。)
     * 每次处理完数据后休眠时间(秒)：execute处理完成之后休眠的时间   一般不改这个值，默认为0
     *
     * 每次处理完休眠时间:子计时单元开始，只要有数据，就会不停的获取不停的处理，这个时间设置后，子计时单元开始每次获取执行后，
     * 不管还有没有待数据，都先歇会儿再获取处理. 写0.0就可以了
     *
     * @param helloTasks
     * @param ownSign
     * @return
     * @throws Exception
     */
    @Override
    public boolean execute(HelloTask[] helloTasks, String ownSign) throws Exception {
        logger.info(Thread.currentThread().getName() + "；正在处理helloTasks:" + new ArrayList<>(Arrays.asList(helloTasks)));
        TimeUnit.SECONDS.sleep(1);
        return true;
    }
}
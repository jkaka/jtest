package com.kaka.jtest.tbschedule.task;

import com.kaka.jtest.tbschedule.entities.TaskModel;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Component("iScheduleTaskDealSingleTest")
public class IScheduleTaskDealSingleTest implements IScheduleTaskDealMulti<TaskModel> {
  
    private static final Logger LOG = LoggerFactory.getLogger(IScheduleTaskDealSingleTest.class);
  
  
   @Override  
    public Comparator<TaskModel> getComparator() {
        return null;  
    }  
    @Override  
    public List<TaskModel> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
                                       List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
  
        //LOG.info("IScheduleTaskDealSingleTest配置的参数，taskParameter:{}，ownSina:{}，taskQueueNum:{},taskItemList:{}, eachFetchDataNum:{}", taskParameter, ownSign, taskQueueNum, taskItemList, eachFetchDataNum);  
  
        LOG.info("IScheduleTaskDealSingleTest选择任务列表开始啦..........");  
        List<TaskModel> models = new ArrayList<TaskModel>();
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest1"));  
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest2"));  
  
        return models;  
  
    }  
    @Override  
    public boolean execute(TaskModel[] model, String ownSign) throws Exception {
  
        LOG.info("IScheduleTaskDealSingleTest执行开始啦.........." + new Date());
        System.out.println(model);  
        return true;  
  
    }  
  
  
}  
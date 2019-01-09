package com.kaka.scheduler;

import org.springframework.expression.ParseException;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jsk
 * @Date 2018/12/20 15:16
 */
public class Main {
    public static void main(String[] args) {
        Date nextTime = new CronTrigger("0/20 * * * * ?")
                .nextExecutionTime(new SimpleTriggerContext());
        System.out.println(nextTime);
    }

    public static List<String> getNextExecTime(String cronExpression, Integer numTimes) {
        List<String> list = new ArrayList<>();
        CronTrigger cronTriggerImpl = new CronTrigger(cronExpression);

        // 这个是重点，一行代码搞定
//        List<Date> dates = cronTriggerImpl.computeFireTimes(cronTriggerImpl, null, numTimes);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (Date date : dates) {
//            list.add(dateFormat.format(date));
//        }
        return list;
    }
}

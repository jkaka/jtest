package com.kaka.scheduler.task;

import java.util.Date;

/**
 * @author jsk
 * @Date 2018/12/21 9:15
 */
public interface TaskHandlerInterface {
    void schedule(Date date, DemoTask demoTask);
}

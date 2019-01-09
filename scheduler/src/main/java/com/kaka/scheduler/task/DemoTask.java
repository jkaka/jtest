package com.kaka.scheduler.task;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jsk
 * @Date 2018/12/20 15:15
 */
public abstract class DemoTask implements Serializable {
    private Date scheduleTime;

    public abstract void execute();

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}

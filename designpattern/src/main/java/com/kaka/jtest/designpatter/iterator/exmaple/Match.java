package com.kaka.jtest.designpatter.iterator.exmaple;

/**
 * @author: jsk
 * @date: 2019/7/20 17:28
 */
public class Match {
    private String matchName;
    /**
     * 比赛时长
     */
    private Integer time;
    /**
     * 比赛结果
     */
    private boolean success;

    public Match(String matchName, Integer time, boolean success) {
        this.matchName = matchName;
        this.time = time;
        this.success = success;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

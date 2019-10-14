package com.kaka.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author jsk
 * @Date 2018/11/21 14:42
 */
public class SnowFlakeUtil {
    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 6; //序列号占用的位数
    private final static long MACHINE_BIT = 5;  //机器标识占用的位数
    private final static long DATACENTER_BIT = 5;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);//最大值31-1
    public final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);//最大值31-1
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);//最大值4095-1

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private final static Long datacenterId = 1L;  //数据中心
    private static Long machineId = 1L;    //机器标识
    private Long sequence = 0L; //序列号
    private Long lastStmp = -1L;//上一次时间戳

    private static SnowFlakeUtil snowFlake;

    public SnowFlakeUtil() {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
    }

    /**
     * 设置机器号
     *
     * @param machineId
     */
    public static synchronized void setMachineId(Long machineId) {
        SnowFlakeUtil.machineId = machineId;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }
        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }
        lastStmp = currStmp;
        return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | datacenterId << DATACENTER_LEFT      //数据中心部分
                | machineId << MACHINE_LEFT            //机器标识部分
                | sequence;                            //序列号部分
    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    public static Long getNextId() throws Exception {
        SnowFlakeUtil snowFlake = getInstance();
        return snowFlake.nextId();
    }

    /**
     * 创建单例的SnowFlakeUtil
     *
     * @return
     * @throws Exception
     */
    public static synchronized SnowFlakeUtil getInstance() throws Exception {
        if (Objects.isNull(snowFlake)) {
            // 1.设置机器Id
            if (Objects.isNull(machineId)) {
                String machineId = System.getProperty("machine_Id");
                if (StringUtils.isNotBlank(machineId)) {
                    SnowFlakeUtil.machineId = Long.parseLong(machineId);
                } else {
                    SnowFlakeUtil.machineId = 123L;
                }
            }
            snowFlake = new SnowFlakeUtil();
        }
        return snowFlake;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(SnowFlakeUtil.getNextId());
        }
    }
}

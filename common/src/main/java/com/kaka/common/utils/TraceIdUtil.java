package com.kaka.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * @author jsk
 * @Date 2018/11/21 14:40
 */
public class TraceIdUtil {
    private static final ThreadLocal<String> traceIdThreadLocal = new ThreadLocal<>();
    private static final LogUtil logger = new LogUtil("traceId");
    private static final String TRACE_ID = "traceId";

    public static String getTraceId() {
        return traceIdThreadLocal.get();
    }

    public static void setTraceId(String traceId) {
        // 把traceId存放到当前线程
        traceIdThreadLocal.set(traceId);
        // 把traceId存放到日志MDC
        MDC.put(TRACE_ID, traceId);
    }

    public static void removeTraceId() {
        traceIdThreadLocal.remove();
    }

    public static String generateTraceId() {
        String traceId = "";
        try {
            String machineId = System.getProperty("machine_Id");
            if (StringUtils.isNotBlank(machineId)) {
                SnowFlakeUtil.setMachineId(Long.parseLong(machineId));
            } else {
                SnowFlakeUtil.setMachineId(1L);
            }
            traceId = SnowFlakeUtil.getNextId().toString();
            TraceIdUtil.setTraceId(traceId);
        } catch (Exception e) {
            logger.error("生成traceId失败", e);
        }
        return traceId;
    }
}

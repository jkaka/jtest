package com.kaka.jtest.consumer.common.utils;

/**
 * @author jsk
 * @Date 2018/8/18 13:10
 */
public class TraceIDUtil {
    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();

    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }
}

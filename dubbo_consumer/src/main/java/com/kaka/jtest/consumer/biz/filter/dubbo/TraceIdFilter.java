package com.kaka.jtest.consumer.biz.filter.dubbo;

import com.kaka.common.utils.TraceIdUtil;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 * 1.在resources中创建文件
 * META-INF/dubbo/com.alibaba.dubbo.rpc.Filter
 * 2.根据需求：consumerConfig.setFilter("consumer_filter");或者providerConfig.setFilter("dubboTraceIdFilter");
 *
 * dubbo服务消费者开始调用、提供者被调用时都可以进入到filter
 * @author jsk
 * @Date 2018/8/18 13:22
 */
public class TraceIdFilter implements Filter {
    private static final String TRACE_ID = "traceId";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation inv) throws RpcException {
        System.out.println("把当前线程中的traceId,通过filter传给dubbo提供者");
        RpcContext.getContext().setAttachment("request.tag","red");
        RpcContext.getContext().setAttachment("request.tag.force","true");
        if (inv.getAttachment(TRACE_ID) != null) {
            // 服务提供方接收traceId：provider接收consumer中的traceId
            TraceIdUtil.setTraceId(inv.getAttachment(TRACE_ID));
            MDC.put(TRACE_ID, TraceIdUtil.getTraceId());
        } else if (TraceIdUtil.getTraceId() != null) {
            inv.getAttachments().put(TRACE_ID, TraceIdUtil.getTraceId());
        }
        inv.getAttachments().put("request.tag","red");
        inv.getAttachments().put("request.tag.force","true");
        return invoker.invoke(inv);
    }
}
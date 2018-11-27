package com.kaka.jtest.provider.biz.filter;

import com.alibaba.dubbo.rpc.*;
import com.kaka.common.utils.TraceIdUtil;

/**
 * 1.在resources中创建文件
 * META-INF/dubbo/com.alibaba.dubbo.rpc.Filter
 *
 * @author jsk
 * @Date 2018/8/18 13:22
 */
public class DubboTraceIdFilter implements Filter {
    private static final String TRACE_ID = "traceId";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation inv) throws RpcException {
        System.out.println("dubboFilter...");
        if (inv.getAttachment(TRACE_ID) != null) {
            // 服务提供方接收traceId：provider接收consumer中的traceId
            TraceIdUtil.setTraceId(inv.getAttachment(TRACE_ID));
        } else {
            if (TraceIdUtil.getTraceId() == null) {
                // invocation和当前线程中都没有traceId,就生成一个
                TraceIdUtil.generateTraceId();
            }
            // 服务消费方传递traceId：consumer调用provider时,把traceId存入到invocation
            inv.getAttachments().put(TRACE_ID, TraceIdUtil.getTraceId());
        }
        return invoker.invoke(inv);
    }
}

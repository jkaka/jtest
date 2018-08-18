package com.kaka.jtest.provider.biz.filter;

import com.alibaba.dubbo.rpc.*;

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
        System.out.println(inv.getAttachment(TRACE_ID));
        return invoker.invoke(inv);
    }
}

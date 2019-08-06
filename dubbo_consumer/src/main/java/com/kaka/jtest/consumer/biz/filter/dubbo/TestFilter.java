package com.kaka.jtest.consumer.biz.filter.dubbo;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * 不写value可以加到默认的过滤器链中
 * org.apache.dubbo.common.extension.ExtensionLoader#isActive(java.lang.String[], org.apache.dubbo.common.URL)
 *
 * @author: jsk
 * @date: 2019/8/5 20:15
 */
@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, value = "testFilter", order = 1)
public class TestFilter implements Filter {
    public TestFilter() {
        System.out.println("testFilter初始化");
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("dubbo test filter ... ");
        return invoker.invoke(invocation);
    }
}

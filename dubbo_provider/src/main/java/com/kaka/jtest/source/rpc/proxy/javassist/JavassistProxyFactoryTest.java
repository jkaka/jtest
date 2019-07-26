package com.kaka.jtest.source.rpc.proxy.javassist;

import com.kaka.common.model.Person;
import org.apache.dubbo.common.bytecode.Wrapper;
import org.apache.dubbo.rpc.proxy.javassist.JavassistProxyFactory;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: jsk
 * @date: 2019/6/26 16:22
 */
public class JavassistProxyFactoryTest {

    @Test
    public void test(){
        Wrapper wrapper = Wrapper.getWrapper(Person.class);
        System.out.println(Arrays.toString(wrapper.getMethodNames()));
    }
}

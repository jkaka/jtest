package com.kaka.jtest.jdk.java.lang.instrument;

import java.lang.instrument.Instrumentation;

/**
 * 一个Java agent既可以在VM启动时加载，也可以在VM启动后加载：
 * <p>
 * 启动时加载：通过vm的启动参数-javaagent:**.jar来启动
 * 启动后加载：在vm启动后的任何时间点，通过attach api，动态地启动agent
 * agent加载时，Java agent的jar包先会被加入到system class path中，然后agent的类会被system class loader加载。
 * 没错，这个system class loader就是所在的Java程序的class loader，这样agent就可以很容易的获取到想要的class。
 * <p>
 *   对于VM启动时加载的Java agent，其premain方法会在程序main方法执行之前被调用，此时大部分Java类都没有被加载（“大部分”是因为，
 * agent类本身和它依赖的类还是无法避免的会先加载的），是一个对类加载埋点做手脚（addTransformer）的好机会。
 * 如果此时premain方法执行失败或抛出异常，那么JVM的启动会被终止。
 * <p>
 *   对于VM启动后加载的Java agent，其agentmain方法会在加载之时立即执行。如果agentmain执行失败或抛出异常，JVM会忽略掉错误，
 * 不会影响到正在running的Java程序。
 *
 * @author: jsk
 * @date: 2019/4/3 14:44
 */
public class AttachAgent {

    /**
     * agentmain名称的方法
     * 以Attach的方式载入，在Java程序启动后执行,其jar包的manifest需要配置属性Agent-Class
     */
    public static void agentmain(String agentArgument, Instrumentation instrumentation) {
        System.out.println("hello agent");
        System.out.println("hello agent!     agentArgument:" + agentArgument);
    }
}

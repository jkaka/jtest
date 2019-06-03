package com.kaka.spring.annotation.bean;

import com.kaka.spring.annotation.properties.RocketMqProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: jsk
 * @date: 2019/3/13 20:39
 */
public class InitBean implements InitializingBean, DisposableBean {

    @Autowired
    private RocketMqProperties rocketMqProperties;

    /**
     * afterPropertiesSet之后执行
     */
    public void initTest() {
        System.out.println("InitBean：@Bean中initMethod指定的方法..." + rocketMqProperties);
    }

    /**
     * 对象创建并赋值之后调用
     * 可以有多个这个注解的方法，在initMethod之前执行
     */
    @PostConstruct
    public void init() {
        System.out.println("InitBean：@PostConstruct注解标注的方法...");
    }

    @PostConstruct
    public void init2() {
        System.out.println("InitBean：@PostConstruct注解标注的方法2...");
    }

    //容器移除对象之前
    @PreDestroy
    public void detory() {
        System.out.println("InitBean：@PreDestroy注解标注的方法...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitBean：DisposableBean接口的覆盖方法...");
    }

    /**
     * @throws Exception
     * @PostConstruct之后执行
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitBean：InitializingBean接口覆盖的方法...");
    }
}

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
     * 1.打注解的方式，最先执行！(可以有多个这个注解的方法)
     */
    @PostConstruct
    public void init() {
        System.out.println("InitBean：@PostConstruct注解标注的方法...");
    }

    @PostConstruct
    public void init2() {
        System.out.println("InitBean：@PostConstruct注解标注的方法2...");
    }

    /**
     * 2. 接口方法在注解之后执行
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitBean：InitializingBean接口覆盖的方法...");
    }

    /**
     * 3.接口方法afterPropertiesSet()之后执行
     */
    public void initTest() {
        System.out.println("InitBean：@Bean中initMethod指定的方法..." + rocketMqProperties);
    }

	/**
	 * 容器移除对象之前
	 */
	@PreDestroy
    public void destroy1() {
        System.out.println("InitBean：@PreDestroy注解标注的方法...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitBean：DisposableBean接口的覆盖方法...");
    }
}

package com.kaka.spring.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/11 20:07:33
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("普通后处理器的初始化前方法,beanName:" + beanName + ";bean:" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("普通后处理器的初始化后方法,beanName:" + beanName + ";bean:" + bean);
        return bean;
    }
}

package com.kaka.spring.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/11 20:08:33
 */
@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("循环依赖的bean，提前获取的beanName:" + beanName);
        return bean;
    }
}

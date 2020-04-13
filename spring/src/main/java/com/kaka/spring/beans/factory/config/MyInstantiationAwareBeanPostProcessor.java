package com.kaka.spring.beans.factory.config;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/11 20:08:02
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 创建bean之前调用
     * 返回值为null，spring会继续根据配置创建bean;否则把该返回值作为bean实例返回
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("创建" + beanName + "前调用,beanName:" + beanName);
        return null;
    }

    /**
     * 创建bean之后,解析bean属性之前调用
     * 返回值为true则继续解析配置的bean属性，返回false则终止解析配置的bean属性，直接返回此时的bean
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("创建bean之后,解析bean属性之前调用,beanName:" + beanName);
        return true;
    }

    /**
     * 解析完成配置的bean属性之后，给bean的属性设置值之前执行
     * 可以修改解析后的PropertyValues(一般会在PropertyValues的基础上创建一个MutablePropertyValues)
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
        String beanName) throws BeansException {
        System.out.println("解析完成配置的bean属性之后，给bean的属性设置值之前执行，beanName:" + beanName);
        // 如果是beanName是department
        if ("department".equals(beanName)) {
            // 从PropertyValues的基础上创建一个MutablePropertyValues
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues(pvs);
            // 创建一个PropertyValue,来承载一个属性的配置。同<property />标签的配置
            PropertyValue propertyValue = new PropertyValue("id", 2);
            // 添加到propertyValueList
            mutablePropertyValues.getPropertyValueList().add(propertyValue);
            return mutablePropertyValues;
        }
        return pvs;
    }
}

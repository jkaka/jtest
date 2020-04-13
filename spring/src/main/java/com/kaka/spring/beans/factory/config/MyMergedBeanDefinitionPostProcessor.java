package com.kaka.spring.beans.factory.config;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/04/11 20:08:49
 */
@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

    /**
     * 创建bean之后，填充属性之前执行。
     * 一般用于根据beanDefinition中属性执行自定义逻辑，或者修改beanDefinition
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if ("department".equals(beanName)) {
            String initMethodName = beanDefinition.getInitMethodName();
            System.out.println(">>>mergedBeanDefinition后处理器执行...");
            System.out.println(">>>原来的初始化方法为:" + initMethodName);
            beanDefinition.setInitMethodName("mergedInitMethod");
        }
    }
}

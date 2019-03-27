package com.kaka.spring.annotation.processor.factory.registry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: jsk
 * @date: 2019/3/14 17:21
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor:postProcessBeanDefinitionRegistry开始");
        for (String name : beanDefinitionRegistry.getBeanDefinitionNames()){
            System.out.println(name);
        }
        System.out.println("BeanDefinitionRegistryPostProcessor:postProcessBeanDefinitionRegistry结束");
//        BeanDefinitionBuilder b = BeanDefinitionBuilder
//                .genericBeanDefinition(RocketMqProperties.class);
//        beanDefinitionRegistry.registerBeanDefinition("rocketMqProperties", b.getBeanDefinition());

//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
//                .rootBeanDefinition(RocketMqProperties.class)
//                .getBeanDefinition();
//        beanDefinitionRegistry.registerBeanDefinition("hello", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        System.out.println("BeanDefinitionRegistryPostProcessor:postProcessBeanFactory;"
//        + configurableListableBeanFactory.getBean("person"));

    }
}

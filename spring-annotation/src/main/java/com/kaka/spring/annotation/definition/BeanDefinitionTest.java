package com.kaka.spring.annotation.definition;

import com.kaka.spring.annotation.bean.Person;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * BeanDefinition用于描述bean实例
 *
 * @author: jsk
 * @date: 2019/4/2 9:15
 */
public class BeanDefinitionTest {

    /**
     * GenericBeanDefinition是BeanDefinition 的通用实现,允许指定bean类，特性及构造器参数值和属性值。
     */
    @Test
    public void genericBeanDefinitionTest() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 1.创建bean定义信息
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Person.class);

        // 2.创建mutable属性值列表
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("name", "张三");

        // 3.把属性列表与bean定义信息相关联
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

        // 4.向容器中注册bean定义信息
        defaultListableBeanFactory.registerBeanDefinition("person", genericBeanDefinition);

        Person bean = defaultListableBeanFactory.getBean(Person.class);
        System.out.println(bean);
    }

    /**
     * beanDefinitionBuilder的rootBeanDefinition方法定义bean信息
     */
    @Test
    public void builderRootBeanDefinitionTest() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 1.创建bean定义信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "李四");

        // 2.向容器中注册bean定义信息
        defaultListableBeanFactory.registerBeanDefinition("person", beanDefinitionBuilder.getBeanDefinition());

        Person bean = defaultListableBeanFactory.getBean(Person.class);
        System.out.println(bean);
    }

    /**
     * beanDefinitionBuilder的genericBeanDefinition方法定义bean信息
     * spring 5.x 支持supplier
     */
    @Test
    public void builderGenericBeanDefinitionTest() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 1.创建bean定义信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class, () -> {
            Person a = new Person(1, "a");
            a.setName("AA");
            return a;
        });

        // 2.向容器中注册bean定义信息
        defaultListableBeanFactory.registerBeanDefinition("person", beanDefinitionBuilder.getBeanDefinition());

        Person bean = defaultListableBeanFactory.getBean(Person.class);
        System.out.println(bean);
    }
}

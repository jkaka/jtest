package com.kaka.spring.beans.factory.support;

import com.kaka.spring.SpringBaseTest;
import com.kaka.spring.pojo.Person;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/29 16:09:57
 */
public class DefaultListableBeanFactoryTest extends SpringBaseTest {

    @Test
    public void registerBeanDefinition() {
        // 创建DefaultListableBeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory(null);

        // 创建BeanDefinitionBuilder(可灵活设置创建bean的方式)
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class,
            Person::new);

        // 注册beanDefinition(beanName可灵活设置)
        defaultListableBeanFactory.registerBeanDefinition("supplierPerson",
            beanDefinitionBuilder.getBeanDefinition());

        // 获取bean
        Object supplierPerson = defaultListableBeanFactory.getBean("supplierPerson");
        System.out.println(supplierPerson);
    }

}

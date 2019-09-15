package com.kaka.spring.beans.factory.config;


import com.kaka.spring.pojo.AbstractMethodBean;
import com.kaka.spring.pojo.Dog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author: jsk
 * @date: 2019/9/15 16:16
 */
public class BeanDefinitionTest {

    private BeanFactory xmlBeanFactory;

    @Before
    public void initFactory(){
        Resource classPathResource = new ClassPathResource("applicationContext.xml");
        xmlBeanFactory = new XmlBeanFactory(classPathResource);
    }

    @Test
    public void metaDataTest(){
        BeanDefinition beanDefinition = ((XmlBeanFactory) xmlBeanFactory).getBeanDefinition("metaPerson");
        Object myMeta = beanDefinition.getAttribute("myMeta");
        System.out.println(myMeta);
    }

    @Test
    public void lookupMethodTest(){
        AbstractMethodBean abstractMethodBean = xmlBeanFactory.getBean("abstractMethodBean", AbstractMethodBean.class);
        abstractMethodBean.printSay();
    }

    @Test
    public void replaceMethodTest(){
        Dog dog = xmlBeanFactory.getBean("dog", Dog.class);
        dog.say();
    }

    @After
    public void destroyFactory(){
    }
}

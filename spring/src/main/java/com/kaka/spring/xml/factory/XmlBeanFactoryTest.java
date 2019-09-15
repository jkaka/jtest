package com.kaka.spring.xml.factory;

import com.kaka.spring.pojo.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author: jsk
 * @date: 2019/5/12 20:58
 */
public class XmlBeanFactoryTest {
    public static void main(String[] args) {
        Resource classPathResource = new ClassPathResource("applicationContext.xml");
        BeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);


        Person person = (Person) xmlBeanFactory.getBean("person");
        System.out.println(person);
    }
}

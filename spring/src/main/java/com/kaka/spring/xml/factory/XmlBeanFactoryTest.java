package com.kaka.spring.xml.factory;

import com.kaka.spring.beans.Person;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author: jsk
 * @date: 2019/5/12 20:58
 */
public class XmlBeanFactoryTest {
    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Person person = (Person) xmlBeanFactory.getBean("person");
        System.out.println(person);
    }
}

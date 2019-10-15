package com.kaka.spring.core;

import com.kaka.spring.pojo.Person;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-15 15:21
 */
public class AliasTest {

    /**
     * 通过别名获取到的是同一个对象
     * 别名信息保存在：SimpleAliasRegistry#aliasMap
     */
    @Test
    public void alias(){
        Resource classPathResource = new ClassPathResource("applicationContext.xml");
        BeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);

        Person personAlias01 = (Person) xmlBeanFactory.getBean("personAlias01");
        Person person = (Person) xmlBeanFactory.getBean("person");
        System.out.println(person == personAlias01);
    }
}

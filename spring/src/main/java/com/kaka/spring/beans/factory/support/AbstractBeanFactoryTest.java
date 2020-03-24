package com.kaka.spring.beans.factory.support;

import com.kaka.spring.SpringBaseTest;
import com.kaka.spring.pojo.factorybean.MyFactoryBean;
import com.kaka.spring.pojo.Person;
import org.junit.Test;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/08 17:13:34
 */
public class AbstractBeanFactoryTest extends SpringBaseTest {

    @Test
    public void getObjectForBeanInstance(){
        Person myPerson = xmlBeanFactory.getBean("myPersonFactoryBean", Person.class);
        System.out.println(myPerson);

        MyFactoryBean myFactoryBean = xmlBeanFactory.getBean("&myPersonFactoryBean", MyFactoryBean.class);
        System.out.println(myFactoryBean);

        Person person = xmlBeanFactory.getBean("person", Person.class);
        System.out.println(person);
    }
}

package com.kaka.spring.context;

import com.kaka.spring.pojo.Department;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: jsk
 * @date: 2019/5/3 21:50
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
            "applicationContext.xml");
        Department bean = classPathXmlApplicationContext.getBean("testA", Department.class);
        System.out.println(bean);
    }
}

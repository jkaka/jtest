package com.kaka.spring.annotation;

import com.kaka.spring.annotation.configure.MyConfigure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: jsk
 * @date: 2019/3/12 22:47
 */
public class ConfigureTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfigure.class);
        Object person = annotationConfigApplicationContext.getBean("person");
        System.out.println(person);
    }
}

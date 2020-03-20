package com.kaka.spring.annotation.test;

import com.kaka.spring.annotation.configure.BeanPostProcessorConfigure;
import com.kaka.spring.annotation.configure.MyConfigure;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/15 11:24:42
 */
public class BeanPostProcessorTest {

    @Test
    public void g(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(BeanPostProcessorConfigure.class);
        Object person = annotationConfigApplicationContext.getBean("person");
        System.out.println(person);
        annotationConfigApplicationContext.close();
    }
}

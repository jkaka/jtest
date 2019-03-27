package com.kaka.spring.annotation.configure;

import com.kaka.spring.annotation.properties.RocketMqProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jsk
 * @date: 2019/3/21 13:41
 */
@Configuration
@ComponentScan("com.kaka.spring.annotation.processor.factory")
public class FactoryProcessorConfigure {

    @Bean
    public RocketMqProperties rocketMqProperties(){
        return new RocketMqProperties();
    }
//    @Bean
//    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
//        return new MyBeanFactoryPostProcessor();
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(FactoryProcessorConfigure.class);
        System.out.println(annotationConfigApplicationContext.getBean("myBeanFactoryPostProcessor"));
    }
}

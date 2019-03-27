package com.kaka.spring.annotation.configure;

import com.kaka.spring.annotation.aware.EnvAware;
import com.kaka.spring.annotation.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jsk
 * @date: 2019/3/21 12:49
 */
@Configuration
@ComponentScan("com.kaka.spring.annotation.aware")
public class AwareOrderConfigure {
    @Bean
    public Person person() {
        System.out.println("@Bean注解创建person...");
        return new Person(1, "AA");
    }

    @Bean
    public EnvAware envAware(){
        System.out.println("@Bean注解创建envAware...");
        return new EnvAware();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AwareOrderConfigure.class);
        System.out.println(annotationConfigApplicationContext.getBean("envAware"));
    }
}

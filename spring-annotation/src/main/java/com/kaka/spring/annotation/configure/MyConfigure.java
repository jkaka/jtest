package com.kaka.spring.annotation.configure;

import com.kaka.spring.annotation.bean.InitBean;
import com.kaka.spring.annotation.bean.Person;
import com.kaka.spring.annotation.processor.factory.registry.MyBeanDefinitionRegistryPostProcessor;
import com.kaka.spring.annotation.properties.RocketMqProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 如果配置类中有BeanFactoryPostProcessor的bean,该配置类中被@Autowired注入的属性就会为null
 *
 * @author: jsk
 * @date: 2019/3/12 22:41
 */
@Configuration
@ComponentScan({"com.kaka.spring.annotation.bean",
        "com.kaka.spring.annotation.processor.factory.bean",
        "com.kaka.spring.annotation.processor.factory"})
@Import({RocketMqProperties.class})
public class MyConfigure {

    /**
     *
     */
    @Autowired
    private RocketMqProperties rocketMqProperties;

    @Bean
    public Person person() {
        System.out.println("@Bean注解创建person...");
        System.out.println("@Bean注入的rocketMqProperties:" + rocketMqProperties);
        return new Person(1, "AA");
    }

    //    @Bean
    public MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor() {
        return new MyBeanDefinitionRegistryPostProcessor();
    }

    //    @Bean
//    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
//        return new MyBeanFactoryPostProcessor();
//    }

    @Bean(initMethod = "initTest")
    public InitBean initBean() {
        return new InitBean();
    }
}

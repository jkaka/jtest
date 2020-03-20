package com.kaka.spring.annotation.configure;

import com.kaka.spring.annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiashuangkai
 * @version 1.0.0
 * @since 2020/03/15 11:25:54
 */
@Configuration
@ComponentScan("com.kaka.spring.annotation.processor.bean")
public class BeanPostProcessorConfigure {

    @Bean
    public Person person(){
        return new Person();
    }
}

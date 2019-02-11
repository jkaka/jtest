package com.kaka.spring.config;

import com.kaka.spring.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jsk
 * @Date 2019/1/29 16:20
 */
@Configuration
public class MyConfig {

    @Bean("person02")
    public Person person(){
        return new Person("lisi", 20);
    }

}

package com.kaka.spring.annotation.configure;

import com.kaka.spring.annotation.bean.GenericityBean;
import com.kaka.spring.annotation.bean.InitBean;
import com.kaka.spring.annotation.bean.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author: jsk
 * @date: 2019/3/21 22:54
 */
@Configuration
@Data
public class GenericityConfigure {

    @Autowired
    private Map<String, GenericityBean<Person>> genericityBeanMap;

    @Bean
    public GenericityBean genericityBeanOne(){
        return new GenericityBean<Person>();
    }

    @Bean
    public GenericityBean<Person> genericityBeanTwo(){
        GenericityBean<Person> genericityBean = new GenericityBean<>();
        genericityBean.add(new Person(1,"AA"));
        return genericityBean;
    }

    @Bean
    public GenericityBean<InitBean> genericityBeanThree(){
        return new GenericityBean<>();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(GenericityConfigure.class);
        GenericityConfigure genericityConfigure = annotationConfigApplicationContext.getBean("genericityConfigure", GenericityConfigure.class);
        System.out.println(genericityConfigure);
        Map<String, GenericityBean<Person>> genericityBeanMap = genericityConfigure.getGenericityBeanMap();
        System.out.println(genericityBeanMap);

        for(String key : genericityBeanMap.keySet()){
            GenericityBean<Person> personGenericityBean = genericityBeanMap.get(key);
            personGenericityBean.add(new Person(1, "AA"));
        }
    }
}

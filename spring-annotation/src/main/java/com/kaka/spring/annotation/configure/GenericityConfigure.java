package com.kaka.spring.annotation.configure;

import com.kaka.spring.annotation.bean.GenericityBean;
import com.kaka.spring.annotation.bean.InitBean;
import com.kaka.spring.annotation.bean.Person;
import com.kaka.spring.annotation.bean.ScanBean;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 泛型bean注入(签名上的类型):IOC中原生类型与泛型可以兼容注入;泛型之间不存在子父类关系,不可兼容注入
 *
 * @author: jsk
 * @date: 2019/3/21 22:54
 */
@Configuration
@Data
public class GenericityConfigure {

    /**
     * 可以注入原生类型、Person泛型两种类型的bean
     */
    @Autowired
    private Map<String, GenericityBean<Person>> genericityBeanMap;

    /**
     * 根据Bean【方法签名上的】返回类型注入
     */
    @Autowired
    private GenericityBean<ScanBean> genericityBean;

    @Bean
    public GenericityBean genericityBeanOne() {
        return new GenericityBean<Person>();
    }

    @Bean
    public GenericityBean<Person> genericityBeanTwo() {
        GenericityBean<Person> genericityBean = new GenericityBean<>();
        genericityBean.add(new Person(1, "AA"));
        return genericityBean;
    }

    @Bean
    public GenericityBean<InitBean> genericityBeanThree() {
        return new GenericityBean<>();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(GenericityConfigure.class);
        GenericityConfigure genericityConfigure = annotationConfigApplicationContext.getBean("genericityConfigure", GenericityConfigure.class);
        System.out.println(genericityConfigure);
        System.out.println(genericityConfigure.genericityBean);
        Map<String, GenericityBean<Person>> genericityBeanMap = genericityConfigure.getGenericityBeanMap();
        System.out.println(genericityBeanMap);

        for (String key : genericityBeanMap.keySet()) {
            GenericityBean<Person> personGenericityBean = genericityBeanMap.get(key);
            personGenericityBean.add(new Person(1, "AA"));
        }
    }
}

package com.kaka.spring.annotation.processor.factory;

import com.kaka.spring.annotation.properties.RocketMqProperties;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanDefinitionRegistryPostProcessor.postProcessBeanFactory之后执行
 * BeanFactoryPostProcessor中不能使用@Autowired注入属性   只能使用getBean
 * DependsOn也没用
 *
 * @author jsk
 * @date 2019/3/13 17:11
 */
@Component
@Data
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Autowired
    private RocketMqProperties rocketMqProperties;

    public MyBeanFactoryPostProcessor() {
        System.out.println("");
    }

    /**
     * 只执行无参的构造方法
     *
     * @param rocketMqProperties
     */
    public MyBeanFactoryPostProcessor(RocketMqProperties rocketMqProperties) {
        this.rocketMqProperties = rocketMqProperties;
    }

    /**
     * 1.注入的属性为null,此时bean都还未初始化  (@Autowired标注的属性,是该bean初始化的时候才注入到此属性)
     * 2.调用getBean方法,对应的bean会提前初始化;但只会触发bean的两类初始化方法(@PostConstruct注解标注的方法不会触发)
     * 2.1 实现InitializingBean接口覆盖 的方法
     * 2.2 @Bean注解中initMethod指定的方法
     *
     * @param configurableListableBeanFactory 描述
     * @throws BeansException 描述
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor:查询出bean的个数" + configurableListableBeanFactory.getBeanDefinitionCount());
//        System.out.println("MyBeanFactoryPostProcessor:" + configurableListableBeanFactory.getBean("person"));
//        System.out.println("MyBeanFactoryPostProcessor:" + configurableListableBeanFactory.getBean("initBean"));
//        System.out.println("MyBeanFactoryPostProcessor:" + configurableListableBeanFactory.getBean("com.kaka.spring.annotation.properties.RocketMqProperties"));
//        System.out.println("MyBeanFactoryPostProcessor:" + configurableListableBeanFactory.getBean("myConfigure"));
        System.out.println("MyBeanFactoryPostProcessor:rocketMqProperties注入为" + rocketMqProperties);
    }
}

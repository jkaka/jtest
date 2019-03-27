package com.kaka.spring.annotation.aware;

import com.kaka.spring.annotation.bean.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author: jsk
 * @date: 2019/3/21 12:45
 */
//@Component
@Data
public class EnvAware implements EnvironmentAware {

    @Autowired
    private Person person;

    public EnvAware() {
        // 此时person为null
        System.out.println("初始化awareBean");
    }

    @Override
    public void setEnvironment(Environment environment) {
        // 此时person会注入进来
        System.out.println("awareBean的aware实现方法");
    }
}

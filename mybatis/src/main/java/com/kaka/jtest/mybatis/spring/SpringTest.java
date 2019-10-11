package com.kaka.jtest.mybatis.spring;

import com.kaka.jtest.mybatis.entities.User;
import com.kaka.jtest.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-10 20:06
 */
public class SpringTest {

    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserMapper userMapper= context.getBean("userMapper", UserMapper.class);
        User user = userMapper.selectOne(5);
        System.out.println(user);
    }
}

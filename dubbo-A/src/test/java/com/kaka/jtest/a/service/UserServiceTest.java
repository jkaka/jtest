package com.kaka.jtest.a.service;

import com.kaka.jtest.a.A_Application;
import com.kaka.jtest.a.config.DubboConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = A_Application.class)
public class UserServiceTest {
    @Autowired
    private DubboConfig dubboConfig;

    @Test
    public void test(){
        System.out.println(dubboConfig);
    }
}

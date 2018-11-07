package com.kaka.jtest.springboot.biz.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jsk
 * @Date 2018/11/5 13:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectList() {
        System.out.println(userService.selectList());
    }

    @Test
    public void selectAge() {
        // 错误信息,预期值,实际值
        Assert.assertSame("错误信息", 10, 10);
    }
}
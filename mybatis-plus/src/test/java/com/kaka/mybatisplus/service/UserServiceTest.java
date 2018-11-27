package com.kaka.mybatisplus.service;

import com.kaka.mybatisplus.ApplicationTest;
import com.kaka.mybatisplus.dataobject.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author jsk
 * @Date 2018/11/27 10:15
 */
public class UserServiceTest extends ApplicationTest {
    @Autowired
    private UserService userService;

    @Test
    public void test(){
        // 新增一个
        User user = new User();
        user.setName("贾双凯");
        user.setAge(29);
//        user.setEmail("88888*****999999");
        userService.save(user);
    }

}
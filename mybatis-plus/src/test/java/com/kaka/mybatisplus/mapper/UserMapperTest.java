package com.kaka.mybatisplus.mapper;

import com.kaka.mybatisplus.ApplicationTest;
import com.kaka.mybatisplus.dataobject.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author jsk
 * @Date 2018/11/8 9:38
 */
public class UserMapperTest extends ApplicationTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
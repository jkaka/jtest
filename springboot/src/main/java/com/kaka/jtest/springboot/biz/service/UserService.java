package com.kaka.jtest.springboot.biz.service;

import com.github.pagehelper.PageInfo;
import com.kaka.jtest.springboot.biz.dataobject.User;

import java.util.List;

/**
 * @author shuangkaijia
 */
public interface UserService {
    PageInfo<User> selectList();

    Integer selectAge(String userName);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Long id);

    User selectOne(Long id);

    void testTx();
}

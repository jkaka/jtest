package com.kaka.mybatisplus.service;

import com.kaka.mybatisplus.dataobject.User;

import java.util.List;

/**
 * @author jsk
 * @Date 2018/11/8 10:14
 */
public interface UserService {

    List<User> selectList();

    User selectOne(Long id);

    Integer deleteUser(Long id);
}

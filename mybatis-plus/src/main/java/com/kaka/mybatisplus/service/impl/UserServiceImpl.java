package com.kaka.mybatisplus.service.impl;

import com.kaka.mybatisplus.dataobject.User;
import com.kaka.mybatisplus.mapper.UserMapper;
import com.kaka.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jsk
 * @Date 2018/11/8 10:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectOne(Long id) {
        return userMapper.selectOne(id);
    }

    @Override
    public List<User> selectList() {
        return userMapper.selectList(null);
    }
}

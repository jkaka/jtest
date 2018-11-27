package com.kaka.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaka.mybatisplus.dataobject.User;
import com.kaka.mybatisplus.mapper.UserMapper;
import com.kaka.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author jsk
 * @Date 2018/11/8 10:14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectOneByName(String name) {
        return baseMapper.selectOneByName(name);
    }
}

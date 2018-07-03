package com.kaka.jtest.springboot.biz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaka.jtest.springboot.biz.dataobject.User;
import com.kaka.jtest.springboot.biz.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> selectList() {
        PageHelper.startPage(2,8);
        List<User> userList = userDao.selectList();

        System.out.println(userList.size());
        PageInfo<User> p=new PageInfo<>(userList);
        return p;
    }
}

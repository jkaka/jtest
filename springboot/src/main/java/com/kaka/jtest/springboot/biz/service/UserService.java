package com.kaka.jtest.springboot.biz.service;

import com.github.pagehelper.PageInfo;
import com.kaka.jtest.springboot.biz.dataobject.User;

import java.util.List;

public interface UserService {
    PageInfo<User> selectList();
}

package com.kaka.jtest.springboot.biz.mapper;


import com.github.pagehelper.Page;
import com.kaka.jtest.springboot.biz.dataobject.User;

import java.util.List;

public interface UserDao {

    Page<User> selectList();
}

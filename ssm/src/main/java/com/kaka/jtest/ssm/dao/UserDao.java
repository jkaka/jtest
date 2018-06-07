package com.kaka.jtest.ssm.dao;

import com.kaka.jtest.ssm.model.User;

import java.util.List;

public interface UserDao {

    List<User> selectList();
}

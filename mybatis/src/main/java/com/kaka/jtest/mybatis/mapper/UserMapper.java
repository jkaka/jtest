package com.kaka.jtest.mybatis.mapper;

import com.kaka.jtest.mybatis.entities.User;

import java.util.HashMap;

/**
 * @author shuangkaijia
 */
public interface UserMapper {
    Integer updateUser(User user);

    User testIf(HashMap<String, Object> hashMap);
}

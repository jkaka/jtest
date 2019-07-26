package com.kaka.jtest.provider.client.service;

import com.kaka.jtest.provider.client.dto.UserDTO;

import java.util.List;

/**
 * @author: jsk
 * @date: 2019/7/17 14:30
 */
public interface UserService {
    List<UserDTO> selectAll();
    UserDTO selectOne(Integer id);
    Integer insert(UserDTO userDTO);
}

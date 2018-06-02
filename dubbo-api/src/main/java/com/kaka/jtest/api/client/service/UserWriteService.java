package com.kaka.jtest.api.client.service;

import com.kaka.jtest.api.client.dto.UserDTO;

import java.util.List;

/**
 * @author shuangkaijia
 */
public interface UserWriteService {
    Integer insert(UserDTO userDTO);
}

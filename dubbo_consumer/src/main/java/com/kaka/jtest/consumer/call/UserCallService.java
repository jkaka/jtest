package com.kaka.jtest.consumer.call;

import com.kaka.jtest.api.client.dto.UserDTO;

import java.util.List;

public interface UserCallService {
    List<UserDTO> selectAll();
    UserDTO selectOne(Integer id);
}

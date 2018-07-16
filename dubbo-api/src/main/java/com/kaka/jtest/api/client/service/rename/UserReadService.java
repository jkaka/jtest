package com.kaka.jtest.api.client.service.rename;

import com.kaka.jtest.api.client.dto.UserDTO;

import java.util.List;

public interface UserReadService {
    List<UserDTO> selectAll();
}

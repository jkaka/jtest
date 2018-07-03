package com.kaka.jtest.springboot.client;

import com.kaka.jtest.springboot.biz.dataobject.User;
import com.kaka.jtest.springboot.client.dto.UserDTO;
import com.kaka.jtest.springboot.common.model.BaseResult;

public interface UserReadService {
    BaseResult<UserDTO> selectOne();
}

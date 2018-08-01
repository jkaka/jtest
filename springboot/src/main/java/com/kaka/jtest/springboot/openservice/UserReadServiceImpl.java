package com.kaka.jtest.springboot.openservice;

import com.kaka.jtest.springboot.client.UserReadService;
import com.kaka.jtest.springboot.client.dto.UserDTO;
import com.kaka.jtest.springboot.common.model.BaseResult;
import com.kaka.jtest.springboot.common.utils.BaseResultUtil;

public class UserReadServiceImpl implements UserReadService {
    @Override
    public BaseResult<UserDTO> selectOne() {
        UserDTO userDTO = null;
        try {
            //-----------
            return BaseResultUtil.handlerSuccess(userDTO, null);
        } catch (Exception e) {
            return BaseResultUtil.handlerFailure(userDTO, e.getMessage());
        }
    }
}

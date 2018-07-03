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
            return BaseResultUtil.handlerSuccessOne(userDTO);
        } catch (Exception e) {
            //logger.info("查询环境配置失败！param：" + JSONObject.toJSONString(ecarxDeviceConfigurationDTO));
            return BaseResultUtil.handlerFailureOne(userDTO);
        }
    }
}

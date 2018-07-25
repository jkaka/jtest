package com.kaka.jtest.provider.biz.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.kaka.jtest.api.client.dto.UserDTO;
import com.kaka.jtest.api.client.service.UserWriteService;

/**
 * @author shuangkaijia
 */
@Service(version = "1.0.0")
public class UserWriteServiceImpl implements UserWriteService {
    @Override
    public Integer insert(UserDTO userDTO) {
        System.out.println("a平台,insert方法...");
        return null;
    }
}

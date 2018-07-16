package com.kaka.jtest.b.biz.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.kaka.jtest.api.client.dto.UserDTO;
import com.kaka.jtest.api.client.service.rename.UserReadService;

import java.util.List;

@Service(version = "1.0.0")
public class UserReadServiceImpl implements UserReadService {
    @Override
    public List<UserDTO> selectAll() {
        System.out.println("b平台，重名的UserReadService...");
        return null;
    }
}

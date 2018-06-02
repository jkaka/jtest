package com.kaka.jtest.a.biz.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.kaka.jtest.api.client.dto.UserDTO;
import com.kaka.jtest.api.client.service.UserReadService;

import java.util.List;

/**
 * @author shuangkaijia
 */
@Service(version = "1.0.0",timeout = 10000)
public class UserReadServiceImpl implements UserReadService {
    @Override
    public List<UserDTO> selectAll() {
        System.out.println("a平台,selectAll方法...");
        return null;
    }

    @Override
    public UserDTO selectOne(Integer id) {
        System.out.println("a平台,selectOne方法...");
        return null;
    }
}

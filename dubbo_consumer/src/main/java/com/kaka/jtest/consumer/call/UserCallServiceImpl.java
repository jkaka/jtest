package com.kaka.jtest.consumer.call;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kaka.jtest.api.client.dto.UserDTO;
import com.kaka.jtest.api.client.service.UserReadService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuangkaijia
 */
@Service
public class UserCallServiceImpl implements UserCallService {
    @Reference(version = "1.0.0")
    private UserReadService userReadService;

    @Override
    public List<UserDTO> selectAll() {
        return userReadService.selectAll();
    }

    @Override
    public UserDTO selectOne(Integer id) {
        return userReadService.selectOne(id);
    }
}

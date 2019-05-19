package com.kaka.jtest.provider.biz.service;

import com.kaka.jtest.api.client.dto.UserDTO;
import com.kaka.jtest.api.client.service.UserReadService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shuangkaijia
 */
//@Service(version = "1.0.0", timeout = 10000)
@Service(version = "1.0.0")
public class UserReadServiceImpl implements UserReadService {
    public UserReadServiceImpl() {
        System.out.println("创建UserReadServiceImpl...");
    }

    @Override
    public UserDTO selectOne(Integer id) {
        System.out.println("a平台,selectOne方法...");
        System.out.println("service3");
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserDTO> selectAll() {
        System.out.println("a平台,selectAll方法...");
        return null;
    }
}

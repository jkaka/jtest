package com.kaka.jtest.provider.client.service;

import com.kaka.jtest.provider.client.dto.UserDTO;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: jsk
 * @date: 2019/7/17 14:31
 */
@Service(version = "1.0.0", tag = "tag0001")
public class UserServiceImpl implements UserService {
    private String serviceName = "provider1";

    @Override
    public UserDTO selectOne(Integer id) {
        System.out.println(serviceName + ":selectOne方法...");
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName(UUID.randomUUID().toString());
        return userDTO;
    }

    @Override
    public List<UserDTO> selectAll() {
        System.out.println(serviceName + ":selectAll方法...");
        List<UserDTO> arrayList = new ArrayList<UserDTO>() {{
            UserDTO userDTO = new UserDTO();
            userDTO.setId(new Double(Math.random() * 100).intValue());
            userDTO.setName(UUID.randomUUID().toString());

            UserDTO userDTO1 = new UserDTO();
            userDTO1.setId(new Double(Math.random() * 100).intValue());
            userDTO1.setName(UUID.randomUUID().toString());

            add(userDTO);
            add(userDTO1);
        }};
        return arrayList;
    }

    @Override
    public Integer insert(UserDTO userDTO) {
        System.out.println(serviceName + ":insert方法...");
        return null;
    }
}

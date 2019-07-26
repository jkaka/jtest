package com.kaka.jtest.mybatis.mapper;

import com.kaka.jtest.mybatis.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuangkaijia
 */
public interface UserMapper {
    Integer updateUser(User user);

    User testIf(HashMap<String, Object> hashMap);

    User selectOne(int id);

    User selectByName(String name);

    User selectMultiParam(@Param("param") Map<String, Object> map, @Param("name") String name);
}

package com.kaka.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaka.mybatisplus.dataobject.User;

/**
 * @author jsk
 * @Date 2018/9/26 16:45
 */
public interface UserMapper extends BaseMapper<User> {
    User selectOneByName(String name);
}

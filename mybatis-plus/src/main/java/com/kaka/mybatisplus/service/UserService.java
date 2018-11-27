package com.kaka.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaka.mybatisplus.dataobject.User;

import java.util.List;

/**
 * @author jsk
 * @Date 2018/11/8 10:14
 */
public interface UserService extends IService<User> {
    User selectOneByName(String name);
}

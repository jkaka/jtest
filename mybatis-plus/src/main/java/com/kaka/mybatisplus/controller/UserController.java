package com.kaka.mybatisplus.controller;

import com.kaka.mybatisplus.dataobject.User;
import com.kaka.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jsk
 * @Date 2018/11/8 10:14
 */
@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

    public List<User> selectList() {
        return userService.selectList();
    }


    @GetMapping("/user/{id}")
    public User selectOne(@PathVariable Long id) {
        return userService.selectOne(id);
    }

}

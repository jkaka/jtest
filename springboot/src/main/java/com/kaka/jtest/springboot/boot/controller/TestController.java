package com.kaka.jtest.springboot.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.kaka.jtest.springboot.biz.dataobject.User;
import com.kaka.jtest.springboot.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jsk
 * @Date 2018/11/5 11:26
 */
@RestController
@RequestMapping("/testController")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User selectOne(@PathVariable Long id){
        return userService.selectOne(id);
    }

    @PostMapping("/user")
    public Integer addUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @PutMapping("/user")
    public Integer updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public Integer deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PostMapping("/user/test")
    public Integer deleteUser(@RequestBody JSONObject jsonObject){

        System.out.println("jsonObject:" + jsonObject);
        return 0;
    }

}

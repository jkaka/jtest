package com.kaka.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaka.mybatisplus.dataobject.User;
import com.kaka.mybatisplus.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/11/8 10:14
 */
@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增一个
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User insertUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    /**
     * 新增多个
     * @param userList
     * @return
     */
    @PostMapping("/user/saveBatch")
    public boolean insertUser(@RequestBody List<User> userList) {
        return userService.saveBatch(userList);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User selectOne(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/user/name/{name}")
    public User selectOneByName(@PathVariable String name) {
        return userService.selectOneByName(name);
    }

    /**
     * 根据条件查询一个对象
     *
     * @param param
     * @return
     */
    @PostMapping("/user/selectOne")
    public User selectOne(@RequestBody Map<String, Object> param) {
        return userService.getOne(new QueryWrapper<User>().allEq(param));
    }

    @PostMapping("/user/selectList")
    public IPage<User> selectList(@RequestBody Map<String, Object> param) {
        return userService.page(new Page<>(1, 2), new QueryWrapper<User>().allEq(param));
    }

    /**
     * 根据id更新
     * @param user
     * @return
     */
    @PutMapping("/user")
    public boolean updateUser(@RequestBody User user){
        return userService.updateById(user);
    }

    /**
     * 根据条件更新
     * @param user
     * @return
     */
    @PutMapping("/user/updateByParam")
    public boolean updateUserByParam(@RequestBody User user){
        Wrapper<User> wrapper = new QueryWrapper<User>().eq("name", "Jack");
        return userService.update(user, wrapper);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.removeById(id);
    }

    @DeleteMapping("/user/deleteByParam")
    public boolean deleteUserByParam(@RequestBody User user) {
        return userService.remove(new QueryWrapper<User>().eq("name", user.getName()));
    }
}

package com.kaka.jtest.springboot.biz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaka.jtest.springboot.biz.dataobject.User;
import com.kaka.jtest.springboot.biz.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> selectList() {
        PageHelper.startPage(2, 8);
        List<User> userList = userDao.selectList();

        System.out.println(userList.size());
        PageInfo<User> p = new PageInfo<>(userList);
        return p;
    }

    @Override
    public Integer selectAge(String userName) {
        return userDao.selectAge(userName);
    }

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User selectOne(Long id) {
        return userDao.selectOne(id);
    }

    @Transactional
    @Override
    public void testTx() {
        User user = new User();
        user.setId(1);
        user.setName("CC");
        userDao.updateUser(user);
//        int i = 10 / 0;
        user.setId(2);
        userDao.updateUser(user);
    }

    @Override
    public void nestMethod() {
        System.out.println("第一个方法...");
        oneMethod();
    }

    @Transactional
    public void oneMethod(){
        System.out.println("第二个方法(加上了事务注解)...");
        User user = new User();
        user.setId(1);
        user.setName("CC");
        userDao.updateUser(user);
        int i = 10 / 0;
        user.setId(2);
        userDao.updateUser(user);
    }
}

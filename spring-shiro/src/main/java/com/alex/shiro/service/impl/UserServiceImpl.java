package com.alex.shiro.service.impl;

import com.alex.shiro.mapper.UserMapper;
import com.alex.shiro.model.User;
import com.alex.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String userName) {
        return userMapper.findByUserName(userName);
    }
}

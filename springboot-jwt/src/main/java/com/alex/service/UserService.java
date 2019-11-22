package com.alex.service;

import com.alex.entity.User;
import com.alex.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserService {
    @Resource
    UserMapper userMapper;

    public User findByUsername(User user) {
        return userMapper.findByUsername(user.getUsername());
    }

    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

}

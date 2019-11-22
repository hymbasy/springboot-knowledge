package com.alex.service.impl;

import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void login() {
        System.out.println("login 方法触发了");
    }

    @Override
    public void loginOut() {
        System.out.println("loginOut 方法触发了");
    }


}

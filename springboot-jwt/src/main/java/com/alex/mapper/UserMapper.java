package com.alex.mapper;

import com.alex.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User findByUsername(@Param("username") String username);

    User findUserById(@Param("Id") String Id);
}

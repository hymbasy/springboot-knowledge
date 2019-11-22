package com.alex.shiro.mapper;

import com.alex.shiro.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select(" select * from t_user where username = #{userName}")
    User findByUserName(String userName);
}

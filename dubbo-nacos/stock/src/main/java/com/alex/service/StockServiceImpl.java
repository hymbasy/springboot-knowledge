package com.alex.service;

import com.alex.model.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> listUser() {
        StringBuilder sql = new StringBuilder("select * from t_user");
        List<User> query = jdbcTemplate.query(sql.toString(), new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getInt("status"));
                user.setCreateTime(resultSet.getDate("create_time"));
                return user;
            }
        });
        return query;
    }

}

package com.example.demo.dao;

import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;


    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

}

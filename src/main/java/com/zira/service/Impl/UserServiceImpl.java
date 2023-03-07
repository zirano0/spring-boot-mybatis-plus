package com.zira.service.Impl;

import com.zira.domain.User;
import com.zira.mapper.UserMapper;
import com.zira.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        return users;
    }
}

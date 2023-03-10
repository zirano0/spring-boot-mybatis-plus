package com.zira.controller;

import com.zira.domain.User;
import com.zira.mapper.UserMapper;
import com.zira.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;


    //查询所有
    @GetMapping("/user/findAll")
    public List<User> findAll() {

        List<User> all = userService.findAll();
        log.info("查询到的所有数据：" + all);

        return all;
    }
}

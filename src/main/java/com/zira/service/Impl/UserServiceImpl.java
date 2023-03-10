package com.zira.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zira.domain.User;
import com.zira.mapper.UserMapper;
import com.zira.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            List<User> userList = null;
            //把数据库中的数据缓存到redis
            ObjectMapper objectMapper = new ObjectMapper();
            String user_list = redisTemplate.opsForValue().get("user_list");
            if (Strings.isNotBlank(user_list)) {
                //从redis获取到用户列表
                log.info("从redis获取到数据！！！");
                list = objectMapper.readValue(user_list, List.class);
            } else {
                //从数据查出来的数据
                log.info("从数据库查到的数据！！！");
                list = userMapper.selectList(null);
                //将数据库查询结果存到数据库
                user_list = objectMapper.writeValueAsString(list);
                redisTemplate.opsForValue().set("user_list", user_list);
            }
        } catch (Exception e) {
            log.error("e", e);
        }

        return list;
    }
}

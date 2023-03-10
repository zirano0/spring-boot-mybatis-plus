package com.zira.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zira.domain.User;
import com.zira.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void save() {
        User user = new User();
        user.setAge(23);
        user.setEmail("shx@163.com");
        user.setUsername("孙昊翔");
        user.setPassword("123");
        user.setNickName("gagaga");
        userMapper.insert(user);
    }

    @Test
    public void findById() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String s = "Select * from tb_user where age > 15  ";
        queryWrapper.gt("age", "15");
        queryWrapper.like("username", "zh");

        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findGroup() {
        List<Map<String, Object>> byGroupAge = userMapper.findByGroupAge();
        System.out.println(byGroupAge);
    }

    //分页查询
    @Test
    public void findPage() {
        //设置分页
        Page<User> page = new Page<>(1, 2); // 第几页 一页多少条
        //执行分页
        Page<User> userPage = userMapper.selectPage(page, null);
        long total = page.getTotal();//总条数
        System.out.println("总条数" + total);
        long pages = page.getPages();//总条数
        System.out.println("总页数" + pages);

        List<User> records = userPage.getRecords();
        for (User record : records) {
            System.out.println(record);
        }
    }
}

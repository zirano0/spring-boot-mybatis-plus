package com.zira.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zira.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT age,COUNT(*) total from tb_user GROUP BY age")
    public List<Map<String, Object>> findByGroupAge();

}

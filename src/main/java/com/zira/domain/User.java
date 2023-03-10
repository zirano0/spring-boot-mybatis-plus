package com.zira.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user")  //手动实现数据库配置表
public class User{
    @TableId //知名当前为主键
    private Long id;
    @TableField("username")  //实体类数据与数据库表映射
    private String username;
    private String password;
    private String nickName;
    private Integer age;
    private String email;
}
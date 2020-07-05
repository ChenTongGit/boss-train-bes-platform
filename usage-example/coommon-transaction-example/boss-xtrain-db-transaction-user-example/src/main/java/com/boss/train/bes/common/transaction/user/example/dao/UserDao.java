package com.boss.train.bes.common.transaction.user.example.dao;

import com.boss.train.bes.common.transaction.user.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 配置DAO层
 * @author lzx
 */
@Repository
@Mapper
public interface UserDao {
    /**
     * 增加用户
     * @param user 要添加的用户信息
     */
    @Insert(value="insert into vue_user(name, code, password) values (#{userName}, #{userCode}, #{userPwd})")
    @Options(useGeneratedKeys=true, keyProperty="userName", useCache = true)
    @ResultMap("userMap")
    void add(User user);
    /**
     * 使用姓名查找用户
     * @param name 要查找的用户姓名信息
     */
    @Select(value="select * from vue_user where name=#{userName}")
    @Options(useGeneratedKeys=true, keyProperty="userId", useCache = true)
    @Results(id = "userMap", value = {
        @Result(property = "userName", column = "name"),
        @Result(property = "userCode", column = "code"),
        @Result(property = "userId", column = "id"),
        @Result(property = "userPwd", column = "password")
    })
    List<User> selectByName(@Param("userName") String name);
}
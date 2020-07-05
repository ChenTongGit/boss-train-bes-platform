package com.boss.train.bes.common.transaction.user.example.service;

import com.boss.train.bes.common.transaction.user.example.entity.User;

import java.util.List;

/**
 * @description 用户增删改查服务的接口
 * @author lzx
 */
public interface UserService {
    /**
     *  根据姓名查询用户信息
     * @param name 包含将查询的用户姓名信息
     * @return 返回查询结果
     */
    List<User> selectByName(String name);
    /**
     *  添加用户信息
     * @param user 包含将添加的用户信息
     */
    List<User> addUser(User user);
    /**
     *  添加用户信息
     * @param user 包含将添加的用户信息
     */
    List<User> addUserFail(User user);
}

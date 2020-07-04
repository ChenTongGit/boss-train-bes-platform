package com.boss.train.bes.common.transaction.example.service;

import com.boss.train.bes.common.transaction.example.entity.User;

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
}

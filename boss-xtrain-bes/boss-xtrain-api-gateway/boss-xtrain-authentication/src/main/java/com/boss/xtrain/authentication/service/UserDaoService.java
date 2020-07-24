package com.boss.xtrain.authentication.service;

import com.boss.xtrain.permission.pojo.dto.UserDTO;

/**
 * 远程调用系统管理服务读取用户信息
 * @author lzx
 * @version 1.0.0
 * @date 2020.07.15
 */
public interface UserDaoService {
    UserDTO getUserAllInfo(String userName);
}

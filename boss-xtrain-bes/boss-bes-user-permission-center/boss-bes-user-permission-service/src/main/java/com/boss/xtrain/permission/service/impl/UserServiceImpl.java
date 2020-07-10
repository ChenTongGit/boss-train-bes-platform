package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:43 2020/07/09
 * @Description :user service实现
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserSerivce {

    @Autowired
    UserDao userDao;

    @Override
    public int add(UserDTO dto) {
        return 0;
    }

    @Override
    public int update(UserDTO dto) {
        return 0;
    }

    @Override
    public List<User> query(UserQueryDTO dto) {
        return null;
    }

    @Override
    public List<Role> getRoleByUserId(Long id) {
        return null;
    }

    @Override
    public List<Role> getAllRoles(RoleQueryDTO queryDTO) {
        return null;
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return 0;
    }

    @Override
    public int deleteUserRole(UserRoleDTO userRoleDTO) {
        return 0;
    }

    @Override
    public User getStatusById(Long id) {
        return null;
    }
}

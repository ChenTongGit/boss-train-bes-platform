package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.mapper.UserMapper;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:22 2020/07/08
 * @Description :userDao实现
 * @Version: 1.0
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    UserMapper userMapper;

    @Override
    public int add(UserDTO dto) {
        User user = new User();
        PojoUtils.copyProperties(dto,user);
        return userMapper.insert(user);
    }

    @Override
    public int update(UserDTO dto) {
        User user = new User();
        PojoUtils.copyProperties(dto,user);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> query(UserQueryDTO dto) {
        return userMapper.query(dto);
    }

    @Override
    public List<Role> getRoleByUserId(Long id) {
        return userMapper.getRoleByUserId(id);
    }

    @Override
    public List<Role> getAllRoles(RoleQueryDTO queryDTO) {
        return userMapper.getAllRoles(queryDTO);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return userMapper.deleteByIds(ids);
    }

    @Override
    public int deleteUserRole(UserRoleDTO userRoleDTO) {
        return userMapper.deleteUserRole(userRoleDTO);
    }

    @Override
    public User getStatusById(Long id) {
        return userMapper.getStatusById(id);
    }
}

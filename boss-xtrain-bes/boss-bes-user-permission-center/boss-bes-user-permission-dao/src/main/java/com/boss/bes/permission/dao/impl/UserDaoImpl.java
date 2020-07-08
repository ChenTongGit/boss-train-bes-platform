package com.boss.bes.permission.dao.impl;

import com.boss.bes.permission.dao.UserDao;
import com.boss.bes.permission.mapper.UserMapper;
import com.boss.bes.permission.pojo.dto.UserRoleDTO;
import com.boss.bes.permission.pojo.dto.role.RoleQueryDTO;
import com.boss.bes.permission.pojo.dto.user.UserDTO;
import com.boss.bes.permission.pojo.dto.user.UserQueryDTO;
import com.boss.bes.permission.pojo.entity.Role;
import com.boss.bes.permission.pojo.entity.User;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:22 2020/07/08
 * @Description :userDao实现
 * @Version: 1.0
 */

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
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

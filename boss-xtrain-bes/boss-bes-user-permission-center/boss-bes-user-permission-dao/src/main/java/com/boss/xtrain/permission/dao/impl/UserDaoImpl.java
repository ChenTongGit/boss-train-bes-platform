package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.mapper.UserMapper;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public int insert(UserDTO dto) {
        User user = new User();
        PojoUtils.copyProperties(dto,user);
        return userMapper.insert(user);
    }

    @Override
    public int delete(UserDTO dto) {
        return userMapper.deleteByPrimaryKey(dto.getId());
    }

    @Override
    public int update(UserDTO dto) {
        User user = new User();
        PojoUtils.copyProperties(dto,user);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<UserDTO> queryByCondition(UserQueryDTO dto) {
        User user = new User();
        return PojoUtils.copyListProperties(userMapper.select(user),UserDTO::new);
    }

    @Override
    public List<Role> getRoleByUserId(Long id) {
        return userMapper.getRoleByUserId(id);
    }

    @Override
    public List<Role> getAllRoles(UserQueryDTO queryDTO) {
        return userMapper.getAllRoles(queryDTO);
    }


    @Override
    public int deleteByIds(List<Long> ids) {
        int count = 0;
        for(long id:ids){
            userMapper.deleteByPrimaryKey(id);
            count++;
        }
       return count;
    }

    @Override
    public int deleteUserRole(UserRoleDTO userRoleDTO) {
        return userMapper.deleteUserRole(userRoleDTO);
    }

    @Override
    public int allocateRole(UserRoleDTO userRoleDTO) {
        return userMapper.allocateRole(userRoleDTO);
    }

    @Override
    public User getStatusById(Long id) {
        return userMapper.getStatusById(id);
    }

    @Override
    public boolean isExist(Long id) {
        return userMapper.existsWithPrimaryKey(id);
    }

    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }
}

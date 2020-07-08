package com.boss.bes.permission.dao.impl;

import com.boss.bes.permission.dao.RoleDao;
import com.boss.bes.permission.mapper.RoleMapper;
import com.boss.bes.permission.pojo.dto.RoleResourceDTO;
import com.boss.bes.permission.pojo.dto.UserRoleDTO;
import com.boss.bes.permission.pojo.dto.role.RoleDTO;
import com.boss.bes.permission.pojo.dto.role.RoleQueryDTO;
import com.boss.bes.permission.pojo.dto.user.UserQueryDTO;
import com.boss.bes.permission.pojo.entity.ResourceTreeNode;
import com.boss.bes.permission.pojo.entity.Role;
import com.boss.bes.permission.pojo.entity.User;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :20:55 2020/07/08
 * @Description :roleDao实现
 * @Version: 1.0
 */

@Component
public class RoleDaoImpl implements RoleDao {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int add(RoleDTO dto) {
        Role role = new Role();
        PojoUtils.copyProperties(dto,role);
        return roleMapper.insert(role);
    }

    @Override
    public int update(RoleDTO dto) {
        Role role = new Role();
        PojoUtils.copyProperties(dto,role);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<Role> query(RoleQueryDTO dto) {
        return roleMapper.query(dto);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return roleMapper.deleteByIds(ids);
    }

    @Override
    public List<ResourceTreeNode> getResources() {
        return roleMapper.getResources();
    }

    @Override
    public int allocateUser(UserRoleDTO userRoleDTO) {
        return roleMapper.allocateUser(userRoleDTO);
    }

    @Override
    public int deleteUserRole(List<Long> ids) {
        return roleMapper.deleteUserRole(ids);
    }

    @Override
    public int allocateResource(RoleResourceDTO roleResourceDTO) {
        return roleMapper.allocateResource(roleResourceDTO);
    }

    @Override
    public int deleteRoleResource(List<Long> ids) {
        return roleMapper.deleteRoleResource(ids);
    }

    @Override
    public List<Role> getResourcesByRoleId(Long id) {
        return roleMapper.getResourcesByRoleId(id);
    }

    @Override
    public List<String> getAllRoleId() {
        return roleMapper.getAllRoleId();
    }

    @Override
    public Role getStatusById(Long id) {
        return roleMapper.getStatusById(id);
    }

    @Override
    public List<String> getResourceIdsByRoleId(Long id) {
        return roleMapper.getResourceIdsByRoleId(id);
    }

    @Override
    public List<String> getUserIdsByRoleId(Long id) {
        return roleMapper.getUserIdsByRoleId(id);
    }

    @Override
    public List<RoleDTO> queryName(RoleDTO dto) {
        return roleMapper.queryName(dto);
    }
}

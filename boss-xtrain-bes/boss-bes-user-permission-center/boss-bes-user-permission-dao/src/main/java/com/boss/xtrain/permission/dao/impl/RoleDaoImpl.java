package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.RoleDao;
import com.boss.xtrain.permission.mapper.RoleMapper;
import com.boss.xtrain.permission.pojo.dto.RoleResourceDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.entity.ResourceTreeNode;
import com.boss.xtrain.permission.pojo.entity.Role;
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
    public int insert(RoleDTO dto) {
        Role role = new Role();
        PojoUtils.copyProperties(dto,role);
        return roleMapper.insert(role);
    }

    @Override
    public int delete(RoleDTO dto) {
        return roleMapper.deleteByPrimaryKey(dto);
    }

    @Override
    public int update(RoleDTO dto) {
        Role role = new Role();
        PojoUtils.copyProperties(dto,role);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public List<RoleDTO> queryByCondition(RoleQueryDTO dto) {
        Role role = new Role();
        PojoUtils.copyProperties(dto,role);
        return PojoUtils.copyListProperties(roleMapper.select(role),RoleDTO::new);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public boolean isExist(Long id) {
        return roleMapper.existsWithPrimaryKey(id);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        int count = 0;
        for(Long id:ids){
            roleMapper.deleteByPrimaryKey(id);
            count++;
        }
        return count;
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
    public List<Resource> getResourcesByRoleId(Long id) {
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

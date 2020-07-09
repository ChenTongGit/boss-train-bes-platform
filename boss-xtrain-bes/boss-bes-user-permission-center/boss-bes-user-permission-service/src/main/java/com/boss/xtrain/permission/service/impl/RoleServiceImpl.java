package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.RoleDao;
import com.boss.xtrain.permission.pojo.dto.RoleResourceDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.entity.ResourceTreeNode;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:53 2020/07/08
 * @Description :role service实现
 * @Version: 1.0
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    public boolean isExist(RoleDTO roleDTO){
        List<RoleDTO> roleDTOS = roleDao.queryName(roleDTO);
        return roleDTOS.isEmpty();
    }
    @Override
    public int add(RoleDTO dto) {
        if(isExist(dto))
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_REPEAT_ERROR);
        return roleDao.add(dto);
    }

    @Override
    public int update(RoleDTO dto) {
        if(isExist(dto))
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_REPEAT_ERROR);
        return roleDao.update(dto);
    }

    @Override
    public List<RoleDTO> queryByCondition(RoleQueryDTO dto) {
        List<Role> roles = roleDao.query(dto);
        return PojoUtils.copyListProperties(roles,RoleDTO::new);
    }

    @Override
    public int deleteByIds(List<RoleDTO> roleDTOS) {
        List<Long> ids = new ArrayList<>();
        for(RoleDTO roleDTO : roleDTOS){
            ids.add(roleDTO.getId());
        }
        return roleDao.deleteByIds(ids);
    }

    @Override
    public boolean allocateUser(List<UserRoleDTO> userRoleDTOS) {
        deleteUserRole(userRoleDTOS);
        IdWorker idWorker = new IdWorker();
        if(userRoleDTOS.get(0).getUserId() == null){
            return false;
        }else {
            for (UserRoleDTO userRoleDTO :userRoleDTOS){
                userRoleDTO.setId(idWorker.nextId());
                roleDao.allocateUser(userRoleDTO);
            }
            return true;
        }
    }

    @Override
    public int deleteUserRole(List<UserRoleDTO> userRoleDTOS) {
        List<Long> ids = new ArrayList<>();
        for(UserRoleDTO userRoleDTO : userRoleDTOS){
            ids.add(userRoleDTO.getRoleId());
        }
        return roleDao.deleteUserRole(ids);
    }

    @Override
    public boolean allocateResource(List<RoleResourceDTO> roleResourceDTOS) {
        deleteRoleResource(roleResourceDTOS);
        IdWorker idWorker = new IdWorker();
        if(roleResourceDTOS.get(0).getResourceId() == null){
            return false;
        }else {
            for(RoleResourceDTO roleResourceDTO :roleResourceDTOS){
                roleResourceDTO.setId(idWorker.nextId());
                roleDao.allocateResource(roleResourceDTO);
            }
            return true;
        }
    }

    @Override
    public int deleteRoleResource(List<RoleResourceDTO> roleResourceDTOS) {
        List<Long> ids = new ArrayList<>();
        for(RoleResourceDTO roleResourceDTO:roleResourceDTOS){
            ids.add(roleResourceDTO.getRoleId());
            Role role = roleDao.getStatusById(roleResourceDTO.getRoleId());
            if(role.getStatus() == 1){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_IN_USE);
            }
        }
        return roleDao.deleteRoleResource(ids);
    }

    @Override
    public List<ResourceTreeNode> getResources() {
        return roleDao.getResources();
    }

    @Override
    public List<String> getResourceIdsByRoleId(Long id) {
        return roleDao.getResourceIdsByRoleId(id);
    }

    @Override
    public List<String> getUserIdsByRoleId(Long id) {
        return roleDao.getUserIdsByRoleId(id);
    }
}

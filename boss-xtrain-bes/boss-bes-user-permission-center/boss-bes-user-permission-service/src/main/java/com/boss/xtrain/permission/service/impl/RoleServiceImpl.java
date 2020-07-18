package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.dao.RoleDao;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.pojo.dto.RoleResourceDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.entity.ResourceTreeNode;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableServer.THREAD_POLICY_ID;
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
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Autowired
    OrganizationDao organizationDao;
    @Autowired
    CompanyDao companyDao;

    private IdWorker worker = new IdWorker();


    @Override
    public int insert(RoleDTO dto) {
        if(roleDao.isExist(dto.getId()))
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_REPEAT_ERROR);
        try {
            dto.setId(worker.nextId());
            log.info(dto.toString());
            return roleDao.roleInsert(dto);
//            return roleDao.insert(dto);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_INSERT_ERROR,e);
        }
    }

    @Override
    public int update(RoleDTO dto) {
        if(!roleDao.isExist(dto.getId()))
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_NOT_EXIST_ERROR);
        try {
//            return roleDao.update(dto);
            return roleDao.roleUpdate(dto);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_UPDATE_ERROR,e);
        }
    }

    @Override
    public List<RoleDTO> selectByCondition(RoleQueryDTO dto) {
        try {
            List<RoleDTO> roleDTOS = roleDao.queryByCondition(dto);
            for(RoleDTO roleDTO : roleDTOS){
                roleDTO.setCompanyName(companyDao.selectByKey(roleDTO.getCompanyId()).getName());
                roleDTO.setOrganizationName(organizationDao.selectByPrimaryKey(roleDTO.getOrganizationId()).getName());
            }
            return roleDTOS;
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_QUERY_ERROR,e);
        }
    }

    @Override
    public List<RoleDTO> selectAll() {
        try {
            List<RoleDTO> roleDTOS =  PojoUtils.copyListProperties(roleDao.selectAll(),RoleDTO::new);
            for(RoleDTO roleDTO : roleDTOS){
                roleDTO.setCompanyName(companyDao.selectByKey(roleDTO.getCompanyId()).getName());
                roleDTO.setOrganizationName(organizationDao.selectByPrimaryKey(roleDTO.getOrganizationId()).getName());
            }
            return roleDTOS;
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_QUERY_ERROR,e);
        }
    }

    @Override
    public int delete(RoleDTO dto) {
        if(isInUse(dto)){
           throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_IN_USE);
        }
        try {
            return roleDao.delete(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_DELETE_ERROR,e);
        }
    }

    @Override
    public int delete(List<RoleDTO> roleDTOS) {
        List<Long> ids = new ArrayList<>();
        for(RoleDTO roleDTO : roleDTOS){
            if(isInUse(roleDTO))
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_IN_USE);
            ids.add(roleDTO.getId());
        }
       try {
            return roleDao.deleteByIds(ids);
       }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_DELETE_ERROR,e);
       }
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
                try {
                    roleDao.allocateUser(userRoleDTO);
                }catch (Exception e){
                    throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_ALLOCATE_USER_ERROR,e);
                }
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
            try {
                for(RoleResourceDTO roleResourceDTO :roleResourceDTOS){
                    roleResourceDTO.setId(idWorker.nextId());
                    roleDao.allocateResource(roleResourceDTO);
                }
            }catch (Exception e){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_ALLOCATE_RESOURCE_ERROR,e);
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
    public List<Long> getResourceIdsByRoleId(Long id) {
        return roleDao.getResourceIdsByRoleId(id);
    }

    @Override
    public List<Long> getUserIdsByRoleId(Long id) {
        return roleDao.getUserIdsByRoleId(id);
    }

    private boolean isInUse(RoleDTO dto){
//        return roleDao.getUserIdsByRoleId(dto.getId()).isEmpty();
        return dto.getStatus() == 1;
    }
}

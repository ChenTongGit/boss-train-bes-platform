package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.*;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.entity.User;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.service.UserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:43 2020/07/09
 * @Description :user service实现
 * @Version: 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserSerivce {

    @Autowired
    UserDao userDao;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    PositionDao positionDao;

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    RoleDao roleDao;

    private IdWorker worker = new IdWorker();


    private boolean isInUse(UserDTO dto){
        return dto.getStatus() == 1;
    }
    @Override
    public List<RoleDTO> getRoleByUserId(Long id) {
        return PojoUtils.copyListProperties(userDao.getRoleByUserId(id),RoleDTO::new);
    }

    @Override
    public UserDTO select(UserQueryDTO query) {
        try {
            User user = userDao.selectByKey(query.getId());
            UserDTO dto = new UserDTO();
            PojoUtils.copyProperties(user,dto);
            dto.setUpdateName(userDao.selectByKey(dto.getUpdatedBy()).getName());
            dto.setOrganizationId(companyDao.selectByKey(dto.getCompanyId()).getOrganizationId());
            dto.setOrganizationName(organizationDao.selectByPrimaryKey(dto.getOrganizationId()).getName());
            dto.setCompanyName(companyDao.selectByKey(dto.getCompanyId()).getName());
            dto.setDepartmentName(departmentDao.selectByKey(dto.getDepartmentId()).getName());
            return dto;
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_QUERY_ERROR,e);
        }
    }

    @Override
    public List<RoleDTO> getAllRoles(UserQueryDTO queryDTO) {
        return PojoUtils.copyListProperties(userDao.getAllRoles(queryDTO),RoleDTO::new);
    }

    @Override
    public List<ResourceDTO> getAllResource(UserQueryDTO queryDTO) {
        List<RoleDTO> roleDTOS = getAllRoles(queryDTO);
        List<ResourceDTO> resourceDTOS = new ArrayList<>();
        for(RoleDTO roleDTO : roleDTOS){
            resourceDTOS.addAll(PojoUtils.copyListProperties(roleDao.getResourcesByRoleId(roleDTO.getId()),ResourceDTO::new));
        }
        return resourceDTOS;
    }

    @Override
    public int deleteRoleUser(List<UserRoleDTO> userRoleDTOS) {
        log.info("deleteUserRole:"+userRoleDTOS.toString());
        List<Long> ids = new ArrayList<>();
        for(UserRoleDTO dto : userRoleDTOS){
            ids.add(dto.getUserId());
        }
        log.info("deleteUserRole ids"+ids.toString());
        return userDao.deleteRoleUser(ids);
    }

    @Override
    public boolean allocateRole(List<UserRoleDTO> dtos) {
        log.info("allocateRole "+dtos.toString());
        deleteRoleUser(dtos);
        if(dtos.get(0).getRoleId() == null){
            return false;
        }else {
            try {
                for(UserRoleDTO userRoleDTO :dtos){
                    userRoleDTO.setId(worker.nextId());
                    userDao.allocateRole(userRoleDTO);
                }
            }catch (Exception e){
                log.error(e.getMessage());
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_ALLOCATE_ROLE_ERROR,e);
            }
            return true;
        }
    }

    @Override
    public User getStatusById(Long id) {
        return userDao.getStatusById(id);
    }

    @Override
    public List<RoleDTO> getRoles(UserQueryDTO queryDTO) {
        try {
            return PojoUtils.copyListProperties(userDao.getAllRoles(queryDTO),RoleDTO::new);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ROLE_QUERY_ERROR,e);
        }
    }

    @Override
    public List<UserDTO> getUserByPosition(UserQueryDTO queryDTO) {
        try {
            return userDao.getUserByPosition(queryDTO.getPositionName());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_QUERY_ERROR,e);
        }
    }

    @Override
    public List<UserDTO> selectByCondition(UserQueryDTO query) {
        try {
            List<UserDTO> userDTOS = userDao.queryByCondition(query);
            for(UserDTO userDTO : userDTOS){
                userDTO.setRoleList(PojoUtils.copyListProperties(userDao.getRoles(query),RoleDTO::new));
                userDTO.setUpdateName(userDao.selectByKey(userDTO.getUpdatedBy()).getName());
                userDTO.setOrganizationId(companyDao.selectByKey(userDTO.getCompanyId()).getOrganizationId());
                userDTO.setOrganizationName(organizationDao.selectByPrimaryKey(userDTO.getOrganizationId()).getName());
                userDTO.setCompanyName(companyDao.selectByKey(userDTO.getCompanyId()).getName());
                userDTO.setDepartmentName(departmentDao.selectByKey(userDTO.getDepartmentId()).getName());
            }
            return userDTOS;
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_QUERY_ERROR);
        }
    }

    @Override
    public List<UserDTO> selectAll() {
        try {
            List<User> users = userDao.selectAll();
            log.info(users.toString());
            UserQueryDTO queryDTO = new UserQueryDTO();
            List<UserDTO> userDTOS = PojoUtils.copyListProperties(users,UserDTO::new);
            log.info(userDTOS.toString());
            for(UserDTO userDTO : userDTOS){
                PojoUtils.copyProperties(userDTO,queryDTO);
                userDTO.setOrganizationId(companyDao.selectByKey(userDTO.getCompanyId()).getOrganizationId());
                log.info(userDTO.getName()+" "+userDTO.getOrganizationId());
                userDTO.setOrganizationName(organizationDao.selectByPrimaryKey(userDTO.getOrganizationId()).getName());
                log.info(userDTO.getName()+" "+userDTO.getOrganizationName());
                userDTO.setCompanyName(companyDao.selectByKey(userDTO.getCompanyId()).getName());
                log.info(userDTO.getName()+" "+userDTO.getCompanyName());
                userDTO.setDepartmentName(departmentDao.selectByKey(userDTO.getDepartmentId()).getName());
                log.info(userDTO.getName()+" "+userDTO.getDepartmentName());
                if(userDTO.getUpdatedBy() != null) {
                    userDTO.setUpdateName(userDao.selectByKey(userDTO.getUpdatedBy()).getName());
                    log.info(userDTO.getName() + " " + userDTO.getUpdateName());
                }
                userDTO.setRoleList(PojoUtils.copyListProperties(userDao.getRoles(queryDTO),RoleDTO::new));
            }
            return userDTOS;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_QUERY_ERROR);
        }
    }

    @Override
    public int delete(UserDTO dto) {
        if(isInUse(dto)){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_IN_USE);
        }
        try {
            List<Long> userIds = new ArrayList<>();
            userIds.add(dto.getId());
            userDao.deleteRoleUser(userIds);
            return userDao.delete(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_DELETE_ERROR,e);
        }
    }

    @Override
    public int delete(List<UserDTO> dtoList) {
        List<Long> ids = new ArrayList<>();
        for(UserDTO dto : dtoList){
            if(isInUse(dto))
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_IN_USE);
            ids.add(dto.getId());
        }
        try {
            List<Long> userIds = new ArrayList<>();
            for(UserDTO dto : dtoList){
                userIds.add(dto.getId());
            }
            userDao.deleteRoleUser(userIds);
            return userDao.deleteByIds(ids);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_DELETE_ERROR,e);
        }
    }

    @Override
    public int update(UserDTO dto) {
        if(!userDao.isExist(dto.getId())){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_NOT_EXIST_ERROR);
        }
        try {
            log.info(dto.toString());
//            return userDao.update(dto);
            return userDao.userUpdate(dto);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_UPDATE_ERROR);
        }
    }

    @Override
    public int insert(UserDTO dto) {
        log.info(dto.toString());
        UserQueryDTO query = new UserQueryDTO();
        PojoUtils.copyProperties(dto,query);
        log.info(query.toString());
        List<UserDTO> list = userDao.queryByCondition(query);
        log.info(list.toString());
        if(!list.isEmpty()){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_REPEAT_ERROR);
        }
        try {
            dto.setId(worker.nextId());
//            return userDao.insert(dto);
            return userDao.userInsert(dto);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_INSERT_ERROR,e);
        }
    }
}

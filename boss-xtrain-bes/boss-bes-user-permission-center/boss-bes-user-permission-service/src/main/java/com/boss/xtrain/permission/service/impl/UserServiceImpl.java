package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.service.UserSerivce;
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
public class UserServiceImpl implements UserSerivce {

    @Autowired
    UserDao userDao;

    private IdWorker worker = new IdWorker();


    private boolean isInUse(UserDTO dto){
        return false;
    }
    @Override
    public List<RoleDTO> getRoleByUserId(Long id) {
        return PojoUtils.copyListProperties(userDao.getRoleByUserId(id),RoleDTO::new);
    }

    @Override
    public UserDTO select(UserQueryDTO query) {
        try {
            return userDao.queryByCondition(query).get(0);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_QUERY_ERROR,e);
        }
    }

    @Override
    public List<RoleDTO> getAllRoles(UserQueryDTO queryDTO) {
        return PojoUtils.copyListProperties(userDao.getAllRoles(queryDTO),RoleDTO::new);
    }

    @Override
    public int deleteUserRole(UserRoleDTO userRoleDTO) {
        return userDao.deleteUserRole(userRoleDTO);
    }

    @Override
    public User getStatusById(Long id) {
        return userDao.getStatusById(id);
    }

    @Override
    public List<UserDTO> selectByCondition(UserQueryDTO query) {
        try {
            return userDao.queryByCondition(query);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_QUERY_ERROR);
        }
    }

    @Override
    public List<UserDTO> selectAll() {
        try {
            List<User> resources = userDao.selectAll();
            return PojoUtils.copyListProperties(resources,UserDTO::new);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_QUERY_ERROR);
        }
    }

    @Override
    public int delete(UserDTO dto) {
        if(isInUse(dto)){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_IN_USE);
        }
        try {
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
            return userDao.deleteByIds(ids);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_DELETE_ERROR,e);
        }
    }

    @Override
    public int update(UserDTO dto) {
        if(!userDao.isExist(dto.getId())){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_NOT_EXIST_ERROR);
        }
        try {
            return userDao.update(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_UPDATE_ERROR);
        }
    }

    @Override
    public int insert(UserDTO dto) {
        if(userDao.isExist(dto.getId())){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_REPEAT_ERROR);
        }
        try {
            dto.setId(worker.nextId());
            return userDao.insert(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_USER_INSERT_ERROR,e);
        }
    }
}

package com.boss.xtrain.permission.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper extends CommonMapper<User> {
    /**
    * @param dto
    * @return List<User>
    * @description 查询条件查询
    */
    List<User> query(UserQueryDTO dto);

    /**
    * @param id
    * @return List<Role>
    * @description 通过userid查找用户的角色
    */
    List<Role> getRoleByUserId(Long id);

    /**
    * @param queryDTO
    * @return List<Role>
    * @description 所有角色
    */
    List<Role> getAllRoles(RoleQueryDTO queryDTO);

    /**
    * @param ids
    * @return int
    * @description 通过id批量删除
    */
    int deleteByIds(@Param("ids")List<Long> ids);
    /**
    * @param userRoleDTO
    * @return int
    * @description 删除用户的某一角色
    */
    int deleteUserRole(UserRoleDTO userRoleDTO);

    /**
     * 根据Id获取Status
     *
     * @param id
     * @return User
     */
    User getStatusById(Long id);

}
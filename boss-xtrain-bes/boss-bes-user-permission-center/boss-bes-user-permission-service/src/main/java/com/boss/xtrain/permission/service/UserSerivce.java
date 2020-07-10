package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:42 2020/07/09
 * @Description :user service层
 * @Version: 1.0
 */
public interface UserSerivce {
    /**
     * 添加用户
     *
     * @param dto
     * @return int
     *
     */
    int add(UserDTO dto);

    /**
     *修改user
     *
     * @param dto
     * @return int
     *
     */
    int update(UserDTO dto);

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

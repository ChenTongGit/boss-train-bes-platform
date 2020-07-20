package com.boss.xtrain.permission.service;

import com.boss.xtrain.common.core.web.service.CommonCurdService;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
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
public interface UserSerivce extends CommonCurdService<UserDTO,UserQueryDTO> {
    /**
     * @param id
     * @return List<RoleDTO>
     * @description 通过userid查找用户的角色
     */
    List<RoleDTO> getRoleByUserId(Long id);
    /**
     * @param query
     * @return List<RoleDTO>
     * @description 唯一查找
     */
   UserDTO select(UserQueryDTO query);

    /**
     * @param queryDTO
     * @return List<Role>
     * @description 所有角色
     */
    List<RoleDTO> getAllRoles(UserQueryDTO queryDTO);
    /**
     *
     *
     * @param queryDTO
     * @return List<ResourceDTO>
     *
    */
    List<ResourceDTO> getAllResource(RoleQueryDTO queryDTO);

    /**
     * @param userRoleDTOS
     * @return int
     * @description 删除用户的某一角色
     */
    int deleteRoleUser(List<UserRoleDTO> userRoleDTOS);

    /**
     * 分配角色
     *
     * @param dtos
     * @return boolean
     *
    */
    boolean allocateRole(List<UserRoleDTO> dtos);

    /**
     * 根据Id获取Status
     *
     * @param id
     * @return User
     */
    User getStatusById(Long id);

    /**
     * 查找用户的角色列表
     *
     * @param queryDTO
     * @return List<RoleDTO>
     *
    */
    List<RoleDTO> getRoles(UserQueryDTO queryDTO);

    /**
     * 通过position信息查找user
     *
     * @param queryDTO
     * @return  List<UserDTO>
     *
    */
    List<UserDTO> getUserByPosition(UserQueryDTO queryDTO);
}

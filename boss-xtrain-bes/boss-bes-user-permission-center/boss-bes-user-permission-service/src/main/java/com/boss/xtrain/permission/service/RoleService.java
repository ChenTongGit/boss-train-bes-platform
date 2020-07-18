package com.boss.xtrain.permission.service;

import com.boss.xtrain.common.core.web.service.CommonCurdService;
import com.boss.xtrain.permission.pojo.dto.RoleResourceDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.entity.ResourceTreeNode;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:44 2020/07/08
 * @Description :role service层
 * @Version: 1.0
 */
public interface RoleService extends CommonCurdService<RoleDTO,RoleQueryDTO> {



    /**
     * 角色下分配用户
     *
     * @param userRoleDTOS
     * @return  boolean
     */

    boolean allocateUser(List<UserRoleDTO> userRoleDTOS);

    /**
     * 删除用户角色联系
     *
     * @param userRoleDTOS
     * @return  boolean
     */

    int deleteUserRole(List<UserRoleDTO> userRoleDTOS);

    /**
     * 角色下分配资源
     *
     * @param roleResourceDTOS
     * @return  boolean
     */

    boolean allocateResource(List<RoleResourceDTO> roleResourceDTOS);

    /**
     * 删除角色资源联系
     *
     * @param roleResourceDTOS
     * @return  int
     */
    int deleteRoleResource(List<RoleResourceDTO> roleResourceDTOS);


    /**
     * 通过RoleId查询拥有的资源Id
     *
     * @param id
     * @return List<String>
     */

    List<String> getResourceIdsByRoleId(Long id);


    /**
     * 通过RoleId查询拥有的用户Id
     *
     * @param id
     * @return List<String>
     */

    List<String> getUserIdsByRoleId(Long id);

}

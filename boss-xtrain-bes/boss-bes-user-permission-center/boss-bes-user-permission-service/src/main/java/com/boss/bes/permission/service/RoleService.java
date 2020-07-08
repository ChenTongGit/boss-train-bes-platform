package com.boss.bes.permission.service;

import com.boss.bes.permission.pojo.dto.RoleResourceDTO;
import com.boss.bes.permission.pojo.dto.UserRoleDTO;
import com.boss.bes.permission.pojo.dto.role.RoleDTO;
import com.boss.bes.permission.pojo.dto.role.RoleQueryDTO;
import com.boss.bes.permission.pojo.entity.ResourceTreeNode;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:44 2020/07/08
 * @Description :role service层
 * @Version: 1.0
 */
public interface RoleService {
    /**
     * 添加角色
     *
     * @param dto
     * @return int
     */
    int add(RoleDTO dto) ;

    /**
     * 修改角色
     *
     * @param dto
     * @return int
     */
    int update(RoleDTO dto) ;

    /**
     * 通过查询条件查询
     *
     * @param dto
     * @return List<RoleDTO>
     */
    List<RoleDTO> queryByCondition(RoleQueryDTO dto);

    /**
     * 根据id删除多个职位
     *
     * @param roleDTOS
     * @return int
     * @exception
     */
    int deleteByIds(List<RoleDTO> roleDTOS) ;

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
     * 获取资源树
     *
     * @param
     * @return  List<ResourceTreeNode>
     */
    List<ResourceTreeNode> getResources();

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

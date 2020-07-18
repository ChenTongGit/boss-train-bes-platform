package com.boss.xtrain.permission.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.permission.pojo.dto.RoleResourceDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import com.boss.xtrain.permission.pojo.query.TreeNode;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.entity.ResourceTreeNode;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends CommonMapper<Role> {
    /**
     * 条件查询用户
     *
     * @param dto
     * @return  List<User>
     */

    List<User> getUsers(UserQueryDTO dto);


    /**
     * 获取资源
     *
     * @param
     * @return  List<ResourceTreeNode>
     */

    List<TreeNode> getResources();
    /**
     * 角色下分配用户
     *
     * @param userRoleDTO
     * @return  int
     */

    int allocateUser(UserRoleDTO userRoleDTO);

    /**
     * 删除用户角色联系
     *
     * @param ids
     * @return  int
     */
    int deleteUserRole(@Param("ids") List<Long> ids);


    /**
     * 角色下分配资源
     *
     * @param roleResourceDTO
     * @return  int
     */

    int allocateResource(RoleResourceDTO roleResourceDTO);

    /**
     * 删除角色资源联系
     *
     * @param ids
     * @return  int
     */
    int deleteRoleResource(@Param("ids") List<Long> ids);


    /**
     * 通过RoleId查对应资源
     *
     * @param id
     * @return List<Resource>
     */

    List<Resource> getResourcesByRoleId(Long id);

    /**
     * 获取role表中所有的roleId
     * @return
     */
    List<String> getAllRoleId();


    /**
     * 根据Id获取Status
     *  @param id
     * @return Role
     */
    Role getStatusById(Long id);

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


    /**
     * 获取角色名集合,防止同名角色存在
     *
     * @param dto
     * @return List<RoleDTO>
     */

    List<RoleDTO> queryName (RoleDTO dto);


}
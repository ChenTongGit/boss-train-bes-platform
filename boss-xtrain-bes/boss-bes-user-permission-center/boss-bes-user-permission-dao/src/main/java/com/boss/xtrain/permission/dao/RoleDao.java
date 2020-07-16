package com.boss.xtrain.permission.dao;

import com.boss.xtrain.common.core.web.dao.IBaseDao;
import com.boss.xtrain.permission.pojo.dto.RoleResourceDTO;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.entity.ResourceTreeNode;
import com.boss.xtrain.permission.pojo.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :20:49 2020/07/08
 * @Description :role dao层接口
 * @Version: 1.0
 */
public interface RoleDao extends IBaseDao<RoleDTO,RoleQueryDTO> {
    /**
     *
     * 查询全部
     * @param
     * @return list
     *
    */
    List<Role> selectAll();

    /**
     *
     * 是否存在
     * @param id
     * @return boolean
     *
     */
    boolean isExist(Long id);

    /**
     * 根据id删除多条记录
     *
     * @param ids
     * @return int
     */
    int deleteByIds(@Param("ids") List<Long> ids);

    /**
     * 获取资源
     *
     * @param
     * @return  List<ResourceTreeNode>
     */

    List<ResourceTreeNode> getResources();

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

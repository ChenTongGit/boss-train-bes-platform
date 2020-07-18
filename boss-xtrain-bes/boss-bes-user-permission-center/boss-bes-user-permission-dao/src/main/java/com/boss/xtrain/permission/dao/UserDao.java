package com.boss.xtrain.permission.dao;

import com.boss.xtrain.common.core.web.dao.IBaseDao;
import com.boss.xtrain.permission.pojo.dto.UserRoleDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:16 2020/07/08
 * @Description :user Dao
 * @Version: 1.0
 */
public interface UserDao extends IBaseDao<UserDTO,UserQueryDTO> {

    /**
     * @param id
     * @return List<Role>
     * @description 通过userid查找用户的角色
     */
    List<Role> getRoleByUserId(Long id);

    /**
     * 避开切面注入 update
     *
     * @param dto
     * @return int
     *
    */
    int userUpdate(UserDTO dto);
    /**
     *
     * 避开切面注入 insert
     * @param dto
     * @return int
     *
    */
    int userInsert(UserDTO dto);
    /**
     * @param queryDTO
     * @return List<Role>
     * @description 所有角色
     */
    List<Role> getAllRoles(UserQueryDTO queryDTO);

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
     * 为用户分配角色
     *
     * @param userRoleDTO
     * @return int
     */

    int allocateRole(UserRoleDTO userRoleDTO);

    /**
     * 根据Id获取Status
     *
     * @param id
     * @return User
     */
    User getStatusById(Long id);
    /**
     *
     * 是否存在
     * @param id
     * @return boolean
     *
     */
    boolean isExist(Long id);

    /**
     * 查找全部
     *
     * @param
     * @return list
     *
    */
    List<User> selectAll();

}

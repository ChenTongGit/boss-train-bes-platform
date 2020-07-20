package com.boss.xtrain.permission.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.permission.pojo.entity.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper extends CommonMapper<Resource> {

    /**
     * @param roleId
     * @return List<String>
     * @description 通过roleId查询到该角色拥有的所有操作类型的资源url字符串
     */
    List<String> loadResourceByRoleId(String roleId);

    /**
     * 获取父亲节点列表
     *
     * @param
     * @return  List<Resource>
     */
    List<Resource> queryParent();

    /**
     * 根据Id获取Status
     *  @param id
     * @return Resource
     */
    Resource getStatusById(Long id);
    /**
     *
     * 通过资源Id删除角色资源关系
     * @param resourceId
     * @return int
     *
    */
    int deleteRoleResource( @Param("id") Long resourceId);

    /**
     * 将parentId设为null
     *
     * @param id
     * @return int
     *
    */
    int updateWithNull( @Param("id") Long id);
}
package com.boss.bes.permission.mapper;

import com.boss.bes.permission.pojo.dto.resource.ResourceQueryDTO;
import com.boss.bes.permission.pojo.entity.Resource;
import com.boss.xtrain.common.core.web.dao.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper extends CommonMapper<Resource> {
    /**
     * @param dto
     * @return List<Resource>
     * @description 根据查询条件
     */
    List<Resource> query(ResourceQueryDTO dto);

    /**
     * @param ids
     * @return int
     * @description 根据id删除多条记录
     */
    int deleteByIds(@Param("ids")List<Long> ids);
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
}
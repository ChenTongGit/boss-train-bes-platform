package com.boss.bes.permission.service;

import com.boss.bes.permission.pojo.dto.resource.ResourceDTO;
import com.boss.bes.permission.pojo.dto.resource.ResourceQueryDTO;
import com.boss.bes.permission.pojo.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:28 2020/07/08
 * @Description :resource Service层
 * @Version: 1.0
 */
public interface ResourceService {
    /**
     * @param dto
     * @return int
     * @description 添加资源
     */
    int add(ResourceDTO dto);

    /**
     * @param resourceDTOS
     * @return int
     * @description 根据id删除多条记录
     */
    int deleteByIds(@Param("ids")List<ResourceDTO> resourceDTOS);
    /**
     * @param dto
     * @return int
     * @description 修改数据
     */
    int update(ResourceDTO dto);

    /**
     * @param dto
     * @return List<Resource>
     * @description 根据查询条件
     */
    List<ResourceDTO> query(ResourceQueryDTO dto);

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
    List<ResourceDTO> queryParent();

    /**
     * 根据Id获取Status
     *  @param id
     * @return Resource
     */
    ResourceDTO getStatusById(Long id);
}

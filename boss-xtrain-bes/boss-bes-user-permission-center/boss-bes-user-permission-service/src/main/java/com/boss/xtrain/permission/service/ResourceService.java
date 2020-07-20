package com.boss.xtrain.permission.service;

import com.boss.xtrain.common.core.web.service.CommonCurdService;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:28 2020/07/08
 * @Description :resource Service层
 * @Version: 1.0
 */
public interface ResourceService extends CommonCurdService<ResourceDTO,ResourceQueryDTO> {
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

    /**
     * 
     * 
     * @param dto
     * @return List<TreeDTO>
     * 
    */
//    List<TreeDTO> getAllResourceTree(ResourceQueryDTO dto);
}

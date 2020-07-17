package com.boss.xtrain.permission.dao;

import com.boss.xtrain.common.core.web.dao.IBaseDao;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :10:59 2020/07/08
 * @Description :resource Dao层接口设计
 * @Version: 1.0
 */
public interface ResourceDao extends IBaseDao<ResourceDTO,ResourceQueryDTO> {
    /**
    * @param resourceDTOS
    * @return int
    * @description 根据id删除多条记录
    */
    int deleteByIds(@Param("ids")List<ResourceDTO> resourceDTOS);

    List<Resource> selectAll();

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
     * 是否存在
     * @param id
     * @return boolean
     *
    */
    boolean isExist(Long id);

}

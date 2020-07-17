package com.boss.xtrain.permission.dao;

import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.entity.Organization;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;

import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.06
 */
public interface OrganizationDao {
    /**
     *  条件查询
     * @param query 组织机构query
     * @return 结果
     */
    List<Organization> selectByCondition(OrganizationQuery query);

    /**
     *  条件查询
     * @param orgId 组织机构的 id
     * @return 结果
     */
    Organization selectByPrimaryKey(Long orgId);

    /**
     * 找一个
     * @param query
     * @return
     */
    Organization selectOne(OrganizationQuery query);

    /**
     * 查询所有的组织机构
     * @return 结果
     */
    List<Organization> selectAll();

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    int delete(OrganizationDTO dto);

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    int delete(List<OrganizationDTO> dtoList);

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int update(OrganizationDTO dto);

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int insert(OrganizationDTO dto);

    /**
     * 是否存在
     * @param orgId
     * @return
     */
    boolean existsByKey(Long orgId);
}

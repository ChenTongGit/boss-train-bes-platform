package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.mapper.OrganizationMapper;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.entity.Organization;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.06
 */
@Slf4j
@Component
public class OrganizationDaoImpl implements OrganizationDao {

    @Autowired
    private OrganizationMapper mapper;

    /**
     * 条件查询
     *
     * @param query 组织机构query
     * @return 结果
     */
    @Override
    public List<Organization> selectByCondition(OrganizationQuery query) {
        Organization organization = new Organization();
        PojoUtils.copyProperties(query,organization);
        return mapper.select(organization);
    }

    /**
     * 条件查询
     *
     * @param orgId 组织机构的 id
     * @return 结果
     */
    @Override
    public Organization selectByPrimaryKey(Long orgId) {
        return mapper.selectByPrimaryKey(orgId);
    }

    /**
     * 找一个
     *
     * @param query
     * @return
     */
    @Override
    public Organization selectOne(OrganizationQuery query) {
        Organization organization = new Organization();
        PojoUtils.copyProperties(query,organization);
        return mapper.selectOne(organization);
    }

    /**
     * 查询所有的组织机构
     *
     * @return 结果
     */
    @Override
    public List<Organization> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    @Override
    public int delete(OrganizationDTO dto) {
        return mapper.deleteByPrimaryKey(dto.getId());
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return 删除了多少个
     */
    @Override
    public int delete(List<OrganizationDTO> dtoList) {
        int count = 0;
        for(OrganizationDTO dto:dtoList){
            if(mapper.deleteByPrimaryKey(dto.getId())!=0){
                count++;
            }
        }
        return count;
    }

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int update(OrganizationDTO dto) {
        Organization organization = new Organization();
        PojoUtils.copyProperties(dto,organization);
        return mapper.updateByPrimaryKey(organization);
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int insert(OrganizationDTO dto) {
        Organization organization = new Organization();
        PojoUtils.copyProperties(dto,organization);
        log.info(organization.getName());
        return mapper.insert(organization);
    }

    @Override
    public boolean existsByKey(Long orgId){
        return mapper.existsWithPrimaryKey(orgId);
    }

}

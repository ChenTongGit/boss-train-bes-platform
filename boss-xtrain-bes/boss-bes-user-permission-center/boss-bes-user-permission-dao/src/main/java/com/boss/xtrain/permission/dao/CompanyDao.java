package com.boss.xtrain.permission.dao;

import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
public interface CompanyDao {
    /**
     *  条件查询
     * @param query 组织机构query
     * @return 结果
     */
    List<Company> selectByCondition(CompanyQuery query);

    /**
     * 查所有
     * @return
     */
    List<Company> selectAll();

    List<Company> selectByOrg(Long orgId);

    /**
     * 用主键查
     * @param companyId
     * @return
     */
    Company selectByKey(Long companyId);

    /**
     * 找一个
     * @param query
     * @return
     */
    Company selectOne(CompanyQuery query);

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    int delete(CompanyDTO dto);

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    int delete(List<CompanyDTO> dtoList);

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int update(CompanyDTO dto);

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int add(CompanyDTO dto);

    /**
     *
     * @param companyId
     * @return
     */
    boolean existsByKey(Long companyId);
}

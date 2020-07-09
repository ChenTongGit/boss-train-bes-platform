package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.mapper.CompanyMapper;
import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Resource
    private CompanyMapper mapper;
    /**
     * 条件查询
     *
     * @param query 组织机构query
     * @return 结果
     */
    @Override
    public List<Company> selectByCondition(CompanyQuery query) {
        Company company = new Company();
        PojoUtils.copyProperties(query,company);
        return mapper.select(company);
    }

    /**
     * 查所有
     *
     * @return
     */
    @Override
    public List<Company> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 用主键查
     *
     * @param companyId
     * @return
     */
    @Override
    public Company selectByKey(Long companyId) {
        return mapper.selectByPrimaryKey(companyId);
    }

    /**
     * 找一个
     *
     * @param query
     * @return
     */
    @Override
    public Company selectOne(CompanyQuery query) {
        Company company = new Company();
        PojoUtils.copyProperties(query,company);
        return mapper.selectOne(company);
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    @Override
    public int delete(CompanyDTO dto) {
        return mapper.deleteByPrimaryKey(dto.getId());
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    @Override
    public int delete(List<CompanyDTO> dtoList) {
        int count = 0;
        for(CompanyDTO dto:dtoList){
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
    public int update(CompanyDTO dto) {
        Company company = new Company();
        PojoUtils.copyProperties(dto,company);
        return mapper.updateByPrimaryKey(company);
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int insert(CompanyDTO dto) {
        Company company = new Company();
        PojoUtils.copyProperties(dto,company);
        return mapper.insert(company);
    }

    /**
     * @param companyId
     * @return
     */
    @Override
    public boolean existsByKey(Long companyId) {
        return mapper.existsWithPrimaryKey(companyId);
    }
}

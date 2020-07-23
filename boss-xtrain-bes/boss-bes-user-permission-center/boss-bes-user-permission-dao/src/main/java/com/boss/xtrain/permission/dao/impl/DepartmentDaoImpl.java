package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.mapper.CompanyMapper;
import com.boss.xtrain.permission.mapper.DepartmentMapper;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.entity.Department;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Repository

public class DepartmentDaoImpl implements DepartmentDao {

    @Resource
    private DepartmentMapper mapper;

    @Resource
    private CompanyMapper companyMapper;

    /**
     * 条件查询
     * 点击树上公司或部门查询
     * @param query 组织机构query
     * @return 结果
     */
    @Override
    public List<Department> selectByCondition(DepartmentQuery query) {
        Example example = new Example(Department.class);
        Example.Criteria criteria = example.createCriteria();
        if(query.getParentId()!=null){
            criteria.andEqualTo("parentId",query.getParentId());
        }
        if(query.getId()!=null){
            criteria.andEqualTo("id",query.getId());
        }
        if(query.getCompanyId()!=null){
            criteria.andEqualTo("companyId",query.getCompanyId());
        }
        if(query.getName()!=null){
            criteria.andEqualTo("name",query.getName());
        }
        return mapper.selectByExample(example);
    }

    /**
     * 查组织机构下所有
     * 只需orgId
     * @return 结果
     */
    @Override
    public List<Department> selectAll(DepartmentQuery query) {
        Long orgId = query.getOrganizationId();
        List<Department> all = new ArrayList<>();

        Example companyExample = new Example(Company.class);

        if(orgId!=null){
            Example.Criteria criteriaCom = companyExample.createCriteria();
            criteriaCom.andEqualTo("organizationId",orgId);
            List<Company> companyList = companyMapper.selectByExample(companyExample);
            if(!companyList.isEmpty()){
                all = getManyCompanyDept(companyList);
            }
        }else{
            all = mapper.selectAll();
        }
        return all;
    }

    /**
     * 通过获得的组织机构所负责的公司，对所负责的部门进行搜索
     * @param companyList 组织机构所负责的公司
     * @return 组织机构负责的部门
     */
    private List<Department> getManyCompanyDept(List<Company> companyList){
        List<Department> departmentList = new ArrayList<>();
        for(Company company:companyList){
            Example example = new Example(Department.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("companyId",company.getId());
            List<Department> temp = mapper.selectByExample(example);
            departmentList.addAll(temp);
        }
        return departmentList;
    }

    /**
     * 无条件查所有
     *
     * @return 结果
     */
    @Override
    public List<Department> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Department> selectByCompany(Long companyId) {
        Example example = new Example(Department.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("companyId",companyId);
        return mapper.selectByExample(example);
    }

    /**
     * 用主键找
     *
     * @param departmentId
     * @return
     */
    @Override
    public Department selectByKey(Long departmentId) {
        return mapper.selectByPrimaryKey(departmentId);
    }

    /**
     * 找一个
     *
     * @param query
     * @return
     */
    @Override
    public Department selectOne(DepartmentQuery query) {
        Department department = new Department();
        PojoUtils.copyProperties(query,department);
        return mapper.selectOne(department);
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    @Override
    public int delete(DepartmentDTO dto) {
        return mapper.deleteByPrimaryKey(dto.getId());
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    @Override
    public int delete(List<DepartmentDTO> dtoList) {
        int count = 0;
        for(DepartmentDTO dto:dtoList){
            if(mapper.deleteByPrimaryKey(dto.getId())!=0){
                count++;
            }
        }
        return count;
    }

    /**
     * 更新用户数据
     * 不通过统一的aop切面，updatedBy在controller层获取
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int deptUpdate(DepartmentDTO dto) {
        Department department = new Department();
        PojoUtils.copyProperties(dto,department);
        return mapper.updateByPrimaryKeySelective(department);
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int add(DepartmentDTO dto) {
        Department department = new Department();
        PojoUtils.copyProperties(dto,department);
        department.setVersion(0L);
        return mapper.insertSelective(department);
    }

    /**
     * @param departmentId
     * @return
     */
    @Override
    public boolean existsByKey(Long departmentId) {
        return mapper.existsWithPrimaryKey(departmentId);
    }
}


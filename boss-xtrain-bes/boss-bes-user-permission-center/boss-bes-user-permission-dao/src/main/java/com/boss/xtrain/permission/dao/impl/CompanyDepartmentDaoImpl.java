package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.CompanyDepartmentDao;
import com.boss.xtrain.permission.mapper.CompanyDepartmentMapper;
import com.boss.xtrain.permission.pojo.query.CompanyDepartmentNode;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author 53534 qyq
 * @date 2020.07.15
 */
@Repository
public class CompanyDepartmentDaoImpl implements CompanyDepartmentDao {

    @Autowired
    private CompanyDepartmentMapper companyDepartmentMapper;

    @Override
    public List<CompanyDepartmentNode> query(CompanyQuery query) {
        return companyDepartmentMapper.query(query);
    }

    @Override
    public List<DepartmentTreeNode> getDepartments(Long companyId) {
        return companyDepartmentMapper.getDepartments(companyId);
    }
}

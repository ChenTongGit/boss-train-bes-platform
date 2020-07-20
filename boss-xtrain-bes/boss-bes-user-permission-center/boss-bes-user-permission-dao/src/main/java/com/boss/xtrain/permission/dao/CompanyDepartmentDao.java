package com.boss.xtrain.permission.dao;

import com.boss.xtrain.permission.pojo.query.CompanyDepartmentNode;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.TreeNode;

import java.util.List;

/**
 * @author 53534qyq
 * @date 202.07.15
 */

public interface CompanyDepartmentDao {
    /**
     * 查询公司部门
     *
     * @param query
     * @return List<CompanyDepartmentNode>
     */
    List<CompanyDepartmentNode> query(CompanyQuery query);

    /**
     * 根据公司id获取部门树
     *
     * @param companyId
     * @return List<DepartmentTreeDTO>
     */

    List<TreeNode> getDepartments(Long companyId);
}

package com.boss.xtrain.permission.mapper;

import com.boss.xtrain.permission.pojo.query.CompanyDepartmentNode;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentTreeNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CompanyDepartmentMapper {
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

    List<DepartmentTreeNode> getDepartments(Long companyId);
}

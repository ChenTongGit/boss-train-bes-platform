package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.common.core.web.service.CommonCurdService;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
public interface DepartmentService extends CommonCurdService<DepartmentDTO, DepartmentQuery> {

    /**
     * 查询所有
     * @return
     */
    List<DepartmentDTO> selectAll(DepartmentQuery query);

    DepartmentDTO selectByPrimaryKey(DepartmentQuery query);

    /**
     * 搜索一个
     * @param query query
     * @return
     */
    DepartmentDTO selectOne(DepartmentQuery query);

    /**
     * 使用公司查找下拉框
     * @param query companyId
     * @return 公司下的部门
     */
    List<DepartmentDTO> selectByCompany(DepartmentQuery query);
}


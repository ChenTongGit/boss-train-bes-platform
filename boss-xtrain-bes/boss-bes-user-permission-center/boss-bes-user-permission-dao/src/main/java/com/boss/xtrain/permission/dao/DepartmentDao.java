package com.boss.xtrain.permission.dao;

import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.entity.Department;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
public interface DepartmentDao {
    /**
     *  条件查询
     * @param query 组织机构query
     * @return 结果
     */
    List<Department> selectByCondition(DepartmentQuery query);

    /**
     *  查所有
     * @return 结果
     */
    List<Department> selectAll(DepartmentQuery query);

    /**
     *  无条件查所有
     * @return 结果
     */
    List<Department> selectAll();

    List<Department> selectByCompany(Long companyId);

    /**
     * 用主键找
     * @param departmentId
     * @return
     */
    Department selectByKey(Long departmentId);

    /**
     * 找一个
     * @param query
     * @return
     */
    Department selectOne(DepartmentQuery query);

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    int delete(DepartmentDTO dto);

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    int delete(List<DepartmentDTO> dtoList);

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int update(DepartmentDTO dto);

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int add(DepartmentDTO dto);

    /**
     *
     * @param departmentId
     * @return
     */
    boolean existsByKey(Long departmentId);

}

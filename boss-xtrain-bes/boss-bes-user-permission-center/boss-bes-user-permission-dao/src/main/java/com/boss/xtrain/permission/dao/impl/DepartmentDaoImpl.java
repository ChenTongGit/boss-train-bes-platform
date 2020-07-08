package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.dao.mapper.DepartmentMapper;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.entity.Department;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Resource
    private DepartmentMapper mapper;

    /**
     * 条件查询
     *
     * @param query 组织机构query
     * @return 结果
     */
    @Override
    public List<Department> selectByCondition(DepartmentQuery query) {
        Department department = new Department();
        PojoUtils.copyProperties(query,department);
        return mapper.select(department);
    }

    /**
     * 查所有
     *
     * @return 结果
     */
    @Override
    public List<Department> selectAll() {
        return mapper.selectAll();
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
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int update(DepartmentDTO dto) {
        Department department = new Department();
        PojoUtils.copyProperties(dto,department);
        return mapper.updateByPrimaryKey(department);
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int insert(DepartmentDTO dto) {
        Department department = new Department();
        PojoUtils.copyProperties(dto,department);
        return mapper.insert(department);
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

package com.boss.xtrain.permission.dao;

import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.entity.SystemParam;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
public interface SystemParamDao {
    /**
     *  条件查询
     * @param query 组织机构query
     * @return 结果
     */
    List<SystemParam> selectByCondition(SystemParamQuery query);

    /**
     * 找所有
     * @return
     */
    List<SystemParam> selectAll();

    /**
     * 找组织机构所有
     * @return
     */
    List<SystemParam> selectAllUnderOrg(Long orgId);

    /**
     * 主键查找
     * @param id
     * @return
     */
    SystemParam selectByKey(Long id);

    /**
     * 找一个
     * @param query
     * @return
     */
    SystemParam selectOne(SystemParamQuery query);

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    int delete(SystemParamDTO dto);

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    int delete(List<SystemParamDTO> dtoList);

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int update(SystemParamDTO dto);

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int insert(SystemParamDTO dto);

    /**
     * 批量添加
     * @param dtoList 列表
     * @return
     */
    int insert(List<SystemParamDTO> dtoList);

    /**
     * 是否存在
     * @param id
     * @return
     */
    boolean existsByKey(Long id);
}

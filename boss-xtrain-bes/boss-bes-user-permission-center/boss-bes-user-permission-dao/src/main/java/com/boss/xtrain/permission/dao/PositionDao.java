package com.boss.xtrain.permission.dao;

import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :14:30 2020/07/07
 * @Description :dao层接口
 * @Version: 1.0
 */
public interface PositionDao {
    /**
     * 通过查询条件查询
     *
     * @param dto
     * @return List<Position>
     */
    List<Position> queryByCondition(PositionQueryDTO dto);

    /**
     * @param  ids
     * @return  int 影响行数
     * @description 通过id批量删除职位信息
     */
    int deleteByIds(@Param("ids")List<Long> ids);

    /**
     * @param dto
     * @return int 影响行数
     * @description 新增信息
     */
    int create(PositionDTO dto);

    /**
     * 通过主键删除一条数据
     *
     * @param dto
     * @return int
     *
    */
    int delete(PositionDTO dto);

    /**
     * @param dto
     * @return int 影响行数
     * @description 修改职位信息
     */
    int update(PositionDTO dto);

    /**
     * @param
     * @return  list<position>
     * @description 测试方法
     */
    List<Position> selectAll();

    /**
     * 该id是否存在
     *
     * @param id
     * @return boolean
     *
    */
    boolean isExist(Long id);
}

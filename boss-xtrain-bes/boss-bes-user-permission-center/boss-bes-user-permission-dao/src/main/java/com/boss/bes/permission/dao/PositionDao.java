package com.boss.bes.permission.dao;

import com.boss.bes.permission.pojo.dto.position.PositionDTO;
import com.boss.bes.permission.pojo.dto.position.PositionQueryDTO;
import com.boss.bes.permission.pojo.entity.Position;
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
}

package com.boss.xtrain.permission.mapper;


import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface PositionMapper extends CommonMapper<Position> {
    /**
    * @param dto
    * @return List<position>
    * @description 通过查询条件查找
    */
      List<Position> queryByCondition(PositionQueryDTO dto);
      /**
      * @param ids
      * @return int 影响行数 删除记录数
      * @description 批量删除
      */
      int deleteByIds(@Param("ids") List<Long> ids);

      /**
      * @param
      * @return  list<position>
      * @description 测试方法
      */
      List<Position> selectAll();
}
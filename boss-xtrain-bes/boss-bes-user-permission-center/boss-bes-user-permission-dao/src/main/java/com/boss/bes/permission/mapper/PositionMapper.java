package com.boss.bes.permission.mapper;

import com.boss.bes.permission.pojo.dto.position.PositionQueryDTO;
import com.boss.bes.permission.pojo.entity.Position;
import com.boss.xtrain.common.core.web.dao.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
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
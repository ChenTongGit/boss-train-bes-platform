package com.boss.bes.permission.service;

import com.boss.bes.permission.pojo.dto.position.PositionDTO;
import com.boss.bes.permission.pojo.dto.position.PositionQueryDTO;
import com.boss.bes.permission.pojo.entity.Position;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:08 2020/07/07
 * @Description :service层接口设计
 * @Version: 1.0
 */
public interface PositionService {
    /**
    * @param dto
    * @return int
    * @description 添加职位
    */
    int create(PositionDTO dto);
    /**
    * @param dto
    * @return int
    * @description 修改职位信息
    */
    int update(PositionDTO dto);
    /**
    * @param dto
    * @return List<PositionDTO></PositionDTO>
    * @description 根据查询条件查询
    */
    List<PositionDTO> queryByCondition(PositionQueryDTO dto);
    /**
    * @param ids
    * @return int
    * @description 根据id批量删除职位
    */
    int deleteByIds(List<Long> ids);

    /**
     * @param
     * @return  list<position>
     * @description 测试方法
     */
    List<Position> selectAll();
}

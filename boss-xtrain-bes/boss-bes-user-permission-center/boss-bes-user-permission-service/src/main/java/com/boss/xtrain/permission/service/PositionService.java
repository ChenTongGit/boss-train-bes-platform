package com.boss.xtrain.permission.service;


import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;

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
    * @param positionDTOList
    * @return int
    * @description 根据id批量删除职位
    */
    int deleteByIds(List<PositionDTO> positionDTOList);

    /**
     * 删除一条数据
     *
     * @param dto
     * @return int
     *
    */
    int delete(PositionDTO dto);

    /**
     * @param
     * @return  list<position>
     * @description 测试方法
     */
    List<PositionDTO> selectAll();
}

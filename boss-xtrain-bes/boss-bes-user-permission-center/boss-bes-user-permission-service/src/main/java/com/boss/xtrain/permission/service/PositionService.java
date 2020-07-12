package com.boss.xtrain.permission.service;


import com.boss.xtrain.common.core.web.service.CommonCurdService;
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
public interface PositionService extends CommonCurdService<PositionDTO,PositionQueryDTO> {
    /**
     * 查找一个
     *
     * @param dto
     * @return PositionDTO
     *
    */
    PositionDTO selectOne(PositionQueryDTO dto);
}

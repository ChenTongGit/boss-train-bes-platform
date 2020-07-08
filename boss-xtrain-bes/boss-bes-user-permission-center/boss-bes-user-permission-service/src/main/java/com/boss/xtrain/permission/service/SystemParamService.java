package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.common.core.web.service.CommonCurdService;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
public interface SystemParamService extends CommonCurdService<SystemParamDTO, SystemParamQuery> {
    /**
     * 查询所有
     * @return
     */
    List<SystemParamDTO> selectAll();

    /**
     * 搜索一个
     * @param query query
     * @return
     */
    SystemParamDTO selectOne(SystemParamQuery query);
}

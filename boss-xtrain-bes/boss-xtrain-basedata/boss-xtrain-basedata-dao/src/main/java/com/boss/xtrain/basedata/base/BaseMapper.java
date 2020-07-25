package com.boss.xtrain.basedata.base;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;

/**
 * @author guo xinrui
 * @description basemapper提供给dao通用mapper接口
 * @date 2020/07/08
 */
public interface BaseMapper<T> extends CommonMapper<T>, IdsMapper<T>, ConditionMapper<T> {
}

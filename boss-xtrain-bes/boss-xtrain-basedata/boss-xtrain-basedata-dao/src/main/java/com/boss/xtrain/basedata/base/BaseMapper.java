package com.boss.xtrain.basedata.base;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;

public interface BaseMapper<T> extends CommonMapper<T>, IdsMapper<T>, ConditionMapper<T> {
}

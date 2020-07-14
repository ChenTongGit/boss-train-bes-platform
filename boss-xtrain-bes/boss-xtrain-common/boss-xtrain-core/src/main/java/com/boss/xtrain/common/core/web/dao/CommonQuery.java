package com.boss.xtrain.common.core.web.dao;

import java.util.List;

/**
 * @class CommonQuery
 * @classdesc
 * @author Administrator
 * @date 2020-6-25  15:38
 * @version 1.0.0
 * @see
 * @since
 */
public interface CommonQuery<T,Q> {
    /**
     * @param: 组合的查询条件
     * @return: 满足条件的用户数据集合
     * @see
     * @since
     */
    List<T> queryByCondition(Q query);

}

package com.boss.bes.paper;

import java.util.List;

public interface CommonQuery<T,Q> {
    /**
     * @param: 组合的查询条件
     * @return: 满足条件的用户数据集合
     * @see
     * @since
     */
    List<T> queryByCondition(Q query);
}


package com.boss.xtrain.common.core.web.dao;
/**
 * @class IBaseDao
 * @classdesc 包含最基本的增删改查方法的定义，其他扩展的方法由具体的Dao实现
 * @author Administrator
 * @date 2020-6-19  10:35
 * @version 1.0.0
 * @see
 * @since 
 */
public interface IBaseDao<T,Q> extends CommonQuery<T,Q> {

    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    int insert(T entity);
    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    int delete(T entity);
    /**
     * @param: 
     * @return: 
     * @see
     * @since
     */
    int update(T entity);
}

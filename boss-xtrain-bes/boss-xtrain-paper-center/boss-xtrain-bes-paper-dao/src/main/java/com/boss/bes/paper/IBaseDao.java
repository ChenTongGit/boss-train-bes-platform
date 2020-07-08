package com.boss.bes.paper;

public interface IBaseDao<T,Q> extends CommonQuery<T,Q> {

    /**
     * @param:
     * @return:
     * @see
     * @since
     */
    int save(T entity);
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


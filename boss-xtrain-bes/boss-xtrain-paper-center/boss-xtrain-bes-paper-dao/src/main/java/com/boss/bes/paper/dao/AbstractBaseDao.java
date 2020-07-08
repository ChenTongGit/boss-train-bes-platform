package com.boss.bes.paper.dao;

import com.boss.bes.paper.CommonMapper;
import com.boss.bes.paper.IBaseDao;

import java.util.List;

public abstract class AbstractBaseDao<T,M extends CommonMapper<T>,Q> implements IBaseDao<T,Q> {

    /**
     *  注入框架隔离的Mappper,后面的数据操作依赖此mapper
     */
    protected M myMapper;
    @Override
    public int save(T entity) {
        return myMapper.insert(entity);
    }

    @Override
    public int delete(T entity) {
        return myMapper.delete(entity);
    }

    @Override
    public int update(T entity) {
        return myMapper.updateByPrimaryKey(entity);
    }

    @Override
    public List<T> queryByCondition(Q query) {
        return null;
    }
}


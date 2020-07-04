package com.boss.xtrain.common.core.web.service;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.boss.xtrain.common.core.pojo.BaseVO;
import com.boss.xtrain.common.core.web.dao.CommonMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangyi
 * @date 2018-08-25 17:22
 */
public abstract class CrudService<M extends CommonMapper<T>, T extends BaseDTO,V extends BaseVO, Q extends BaseQuery> extends BaseService {

    @Resource
    protected M dao;

    /**
     * 根据id获取
     *
     * @param id id
     * @return T
     */
    public T get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 获取单条数据
     *
     * @param entity entity
     * @return T
     */
    public T selectByQuery(T entity) {
        // TODO 需要修改
        return dao.selectOne(entity);
    }

    /**
     * 查询列表
     *
     * @param entity entity
     * @return List
     */
    public List<T> selectList(T entity) {
        // TODO 需要修改
        return dao.select(entity);
    }

    /**
     * 查询列表
     *
     * @return List
     */
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 查询列表
     *
     * @param ids ids
     * @return List
     */
    public List<T> findListById(Long[] ids) {
        // TODO 需要修改
        if (ids == null || ids.length == 0)
            return new ArrayList<>();
        return this.dao.selectByExample(ids);
    }

    /**
     * 查询分页
     *
     * @param page   page
     * @param entity entity
     * @return PageInfo
     */
//    public PageInfo<T> findPage(PageInfo<T> page, T entity) {
//        PageMethod.startPage(page.getPageNum(), page.getPageSize());
//        return new PageInfo<>(dao.findList(entity));
//    }

    /**
     * 插入或更新
     *
     * @param entity entity
     * @return int
     */
    @Transactional
    public int save(T entity) {
        return this.dao.insert(entity);
    }

    /**
     * 删除
     *
     * @param entity entity
     * @return int
     */
    @Transactional
    public int delete(T entity) {
        return dao.delete(entity);
    }

    /**
     * 批量删除
     *
     * @param ids ids
     * @return int
     */
    @Transactional
    public int deleteAll(Long[] ids) {
        return this.dao.deleteByExample(ids);
    }

    /**
     * 插入数据
     *
     * @param entity entity
     * @return int
     */
    @Transactional
    public int insert(T entity) {
        return dao.insert(entity);
    }

    /**
     * 更新数据
     *
     * @param entity entity
     * @return int
     */
    @Transactional
    public int update(T entity) {
        // TODO 需要修改
        return dao.updateByPrimaryKey(entity);
    }
}


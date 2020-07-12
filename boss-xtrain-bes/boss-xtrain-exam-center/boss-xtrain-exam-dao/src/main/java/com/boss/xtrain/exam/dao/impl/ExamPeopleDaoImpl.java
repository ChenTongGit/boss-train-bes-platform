package com.boss.xtrain.exam.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.ExamPeopleDao;
import com.boss.xtrain.exam.dao.mapper.ExamPeopleMapper;
import com.boss.xtrain.exam.pojo.dto.query.ExamPeopleQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPeople;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考试人员数据库操作层dao实现类
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 23:45
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Repository
public class ExamPeopleDaoImpl implements ExamPeopleDao {

    @Resource
    private ExamPeopleMapper examPeopleMapper;

    /**
     * 添加
     * @param entity
     * @return: int
     * @see
     * @since
     */
    @Override
    public int insert(ExamPeople entity) {
        return examPeopleMapper.insert(entity);
    }

    /**
     * 删除
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int delete(ExamPeople entity) {
        return examPeopleMapper.deleteWithVersion(entity);
    }

    /**
     * 更新
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int update(ExamPeople entity) {
        return examPeopleMapper.updateByPrimaryKeySelectiveWithVersion(entity);
    }

    /**
     * 条件查询
     * @param query
     * @param: 组合的查询条件
     * @return: 满足条件的用户数据集合
     * @see
     * @since
     */
    @Override
    public List<ExamPeople> queryByCondition(ExamPeopleQuery query) {
        ExamPeople entity = new ExamPeople();
        PojoUtils.copyProperties(query, entity);
        return examPeopleMapper.select(entity);
    }
}

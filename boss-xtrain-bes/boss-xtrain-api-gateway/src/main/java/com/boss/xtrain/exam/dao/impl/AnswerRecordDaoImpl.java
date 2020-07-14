package com.boss.xtrain.exam.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.AnswerRecordDao;
import com.boss.xtrain.exam.dao.mapper.AnswerRecordMapper;
import com.boss.xtrain.exam.pojo.dto.query.AnswerRecordQuery;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 试题作答记录数据库操作接口实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 10:47
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Repository
public class AnswerRecordDaoImpl implements AnswerRecordDao {

    @Resource
    private AnswerRecordMapper mapper;

    /**
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int insert(AnswerRecord entity) {
        return this.mapper.insert(entity);
    }

    /**
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int delete(AnswerRecord entity) {
        return this.mapper.delete(entity);
    }

    /**
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int update(AnswerRecord entity) {
        return this.mapper.updateByPrimaryKeySelectiveWithVersion(entity);
    }

    /**
     * @param query 仅需考试记录id即可
     * @param: 组合的查询条件
     * @return: 满足条件的用户数据集合
     * @see
     * @since
     */
    @Override
    public List<AnswerRecord> queryByCondition(AnswerRecordQuery query) {
        AnswerRecord ans = new AnswerRecord();
        PojoUtils.copyProperties(query, ans);
        return this.mapper.select(ans);
    }

    /**
     * 批量添加
     * @param answerRecordList
     * @return int
     * @author ChenTong
     * @date 2020/7/11 10:52
     */
    @Override
    public int insertBatch(List<AnswerRecord> answerRecordList) {
        return this.mapper.insertBatch(answerRecordList);
    }
}

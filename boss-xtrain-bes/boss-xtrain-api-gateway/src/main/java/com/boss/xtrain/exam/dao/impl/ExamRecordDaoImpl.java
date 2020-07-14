package com.boss.xtrain.exam.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.ExamRecordDao;
import com.boss.xtrain.exam.dao.mapper.ExamRecordMapper;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecordListEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考试记录数据库操作dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 15:41
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Repository
public class ExamRecordDaoImpl implements ExamRecordDao {

    @Resource
    private ExamRecordMapper examRecordMapper;

    /**
     * 初次添加考试记录
     * @param entity
     * @return
     */
    @Override
    public Integer insertBasicRecord(ExamRecord entity) {
        return examRecordMapper.insertSelective(entity);
    }

    /**
     * 获取表格所需要渲染的数据
     * @param query
     * @return
     */
    @Override
    public List<ExamRecordListEntity> queryListDataByCondition(ExamRecordQuery query) {

        return examRecordMapper.queryListDataByCondition(query);
    }

    /**
     * 添加
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int insert(ExamRecord entity) {
        return examRecordMapper.insert(entity);
    }

    /**
     * 删除 观察version
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int delete(ExamRecord entity) {
        return examRecordMapper.deleteByPrimaryKeyWithVersion(entity);
    }

    /**
     * 更新考试记录
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int update(ExamRecord entity) {
        return examRecordMapper.updateByPrimaryKeySelectiveWithVersion(entity);
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
    public List<ExamRecord> queryByCondition(ExamRecordQuery query) {
        ExamRecord record = new ExamRecord();
        PojoUtils.copyProperties(record, query);
        return examRecordMapper.select( record);
    }


}

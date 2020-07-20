package com.boss.xtrain.exam.dao;

import com.boss.xtrain.common.core.web.dao.IBaseDao;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecordListEntity;

import java.util.List;

/**
 * 考试记录数据库接口dao
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/12 15:39
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamRecordDao extends IBaseDao<ExamRecord, ExamRecordQuery> {

    /**
     * 初次添加考试记录
     * @param entity
     * @return
     */
    Integer insertBasicRecord(ExamRecord entity);

    List<ExamRecordListEntity> queryListDataByCondition(ExamRecordQuery query);
}

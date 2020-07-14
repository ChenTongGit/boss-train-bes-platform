package com.boss.xtrain.exam.dao;

import com.boss.xtrain.common.core.web.dao.IBaseDao;
import com.boss.xtrain.exam.pojo.dto.query.AnswerRecordQuery;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;

import java.util.List;

/**
 * 作答记录数据库操作接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 10:44
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface AnswerRecordDao extends IBaseDao<AnswerRecord, AnswerRecordQuery> {
    
    /**
     * 批量添加
     * @author ChenTong
     * @param answerRecordList 
     * @return int
     * @date 2020/7/11 10:52
     */
    int insertBatch(List<AnswerRecord> answerRecordList);
}

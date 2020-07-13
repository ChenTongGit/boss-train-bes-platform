package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecordListEntity;

import java.util.List;


public interface ExamRecordMapper extends CommonMapper<ExamRecord> {

    List<ExamRecordListEntity> queryListDataByCondition(ExamRecordQuery query);
}
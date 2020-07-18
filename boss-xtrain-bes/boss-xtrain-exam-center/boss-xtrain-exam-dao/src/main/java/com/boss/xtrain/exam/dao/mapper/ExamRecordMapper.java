package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.dto.MarkingDataListDto;
import com.boss.xtrain.exam.pojo.dto.ReportDataItemDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.dto.query.MarkingQuery;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecordListEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ExamRecordMapper extends CommonMapper<ExamRecord> {

    /**
     * 通过查询条件查询考试记录
     *
     * @param query
     * @return
     */
    List<ExamRecordListEntity> queryListDataByCondition(ExamRecordQuery query);

    /**
     * 根据publishId查询对应考试的报表详情
     *
     * @param publishId
     * @return
     */
    List<ReportDataItemDTO> queryReportDetail(Long publishId);

    /**
     * 更新考试记录的status，表示已批阅
     *
     * @param examRecord
     * @return
     */
    int updateStatus(@Param("examRecord") ExamRecord examRecord);

    /**
     * 根据条件查询阅卷列表的信息
     *
     * @param queryDto
     * @return
     */
    List<MarkingDataListDto> queryEvaluateByCondition(MarkingQuery queryDto);


}
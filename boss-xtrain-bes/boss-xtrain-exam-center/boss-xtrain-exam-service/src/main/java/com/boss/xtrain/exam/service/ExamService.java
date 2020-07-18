package com.boss.xtrain.exam.service;

import com.boss.xtrain.exam.pojo.dto.AnswerRecordTempInsertDTO;
import com.boss.xtrain.exam.pojo.dto.ExamStartAddRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordDetailQuery;
import com.boss.xtrain.exam.pojo.vo.test.PaperSubjectAnswerVO;

import java.util.List;

/**
 * 手机答卷业务接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 15:29
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamService {
    
    /**
     * 考试开始 初始化考试记录
     * @author ChenTong
     * @param dto 
     * @return java.lang.Integer
     * @date 2020/7/10 15:32
     */
    Long insertBasicExamRecord(ExamStartAddRecordDTO dto);


    /**
     * 考试过程中暂时保存考生回答
     * @author ChenTong
     * @param dtos
     * @return java.lang.Integer
     * @date 2020/7/10 21:47
     */
    Integer insertTemAnswerRecord(List<AnswerRecordTempInsertDTO> dtos);
    
    /**
     * 考试结束提交答案
     * @author ChenTong
     * @param dto 
     * @return java.lang.Integer
     * @date 2020/7/10 23:58
     */
    Integer submitExam(SubmitExamDTO dto);

    Long getLimitTimeFromRedis(String key);

    void setLimitTimeToRedis(String key, Long limit);

    /**
     * 获取试卷
     */
    PaperSubjectAnswerVO getPaper(ExamRecordDetailQuery vo, boolean queryRedis);

}

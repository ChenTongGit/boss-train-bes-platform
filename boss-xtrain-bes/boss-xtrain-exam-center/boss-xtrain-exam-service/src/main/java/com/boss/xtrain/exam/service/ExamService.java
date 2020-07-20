package com.boss.xtrain.exam.service;

import com.boss.xtrain.exam.pojo.dto.AnswerRecordTempInsertDTO;
import com.boss.xtrain.exam.pojo.dto.ExamStartAddRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO;

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

    /**
     * 从redis中获取考试剩余时间
     * @param key
     * @return
     */
    Long getLimitTimeFromRedis(String key);

    /**
     * 设置考试剩余时间
     * @param key
     * @param limit
     */
    void setLimitTimeToRedis(String key, Long limit);

    /**
     * 获取该考生的试卷如果已经进行考试则会返回已经保存的答案
     * @param dto
     * @param queryRedis
     * @return
     */
    PaperSubjectAnswerVO getPaper(SubmitExamDTO dto, boolean queryRedis);

}

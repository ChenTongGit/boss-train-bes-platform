package com.boss.xtrain.exam.service;

import com.boss.xtrain.exam.pojo.dto.MarkingDataItemDTO;
import com.boss.xtrain.exam.pojo.dto.MarkingDataListDto;
import com.boss.xtrain.exam.pojo.dto.MarkingSubmitDTO;
import com.boss.xtrain.exam.pojo.dto.query.MarkingQuery;

import java.util.List;
import java.util.Map;

/**
 * 答卷阅卷管理服务业务接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/12 22:30
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamEvaluateService {

    /**
     * 查询该阅卷官阅卷试题
     * @author ChenTong
     * @param query 
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.MarkingDataListDto>
     * @date 2020/7/14 22:35
     */
    List<MarkingDataListDto> queryByCondition(MarkingQuery query);

    /**
     * 回传试卷阅卷信息到redis中暂时存储
     * @author ChenTong
     * @param markingDataItemDTOS 阅卷试卷期间的阅卷结果列表包含没到题目的打分信息以及评价
     * @param examRecordId 该试卷考试记录ID
     * @return void
     * @date 2020/7/16 15:04
     */
    void tempEvaluateResult(List<MarkingDataItemDTO> markingDataItemDTOS, Long examRecordId);
    
    /**
     * 提交阅卷信息
     * @author ChenTong
     * @param markingSubmitDTO
     * @return boolean
     * @date 2020/7/16 15:07
     */
    boolean submitEvaluate(MarkingSubmitDTO markingSubmitDTO);

  /**
   * 从redis中重新读取展示存储的考试阅卷记录
   * @author ChenTong
   * @param examRecordId 考试记录的id
   * @return java.util.Map<java.lang.String,com.boss.xtrain.exam.pojo.dto.MarkingDataItemDTO>
   * @date 2020/7/16 15:08
   */
    Map<String, MarkingDataItemDTO> getTempEvaluateResultMap(Long examRecordId);
}

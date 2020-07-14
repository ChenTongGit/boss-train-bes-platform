package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.pojo.dto.AnswerRecordTempInsertDTO;
import com.boss.xtrain.exam.pojo.dto.ExamStartAddRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.vo.ExamBasicInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 手机答卷考试api
 * 不属于常规的增删改查操作
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 11:22
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamApi {
    // 考试开始前 获取考试基本信息

    /**
     * 获取考试基本信息
     * @param request
     * @return
     */
    @PostMapping("/examInfo")
    CommonResponse<ExamBasicInfoVO> getExamBasicInfo(@RequestBody @Valid CommonRequest<Map<String, Long>> request);

    /**
     * 考试开始记录考试
     * @param request
     * @return
     */
    // 考试开始 创建改考生的考试记录 根据该场次的阅卷方式分配阅卷官以及阅卷时间
    @PostMapping("/examRecord")
    CommonResponse<Long> createExamRecord(@RequestBody @Valid CommonRequest<ExamStartAddRecordDTO> request);

    /**
     * 暂时保存答案
     * @param request
     * @return
     */
    @PostMapping("/tempAnswers")
    CommonResponse<Integer> saveTempAnswers(@RequestBody @Valid CommonRequest<List<AnswerRecordTempInsertDTO>> request);

    // 提交答案 更新考试记录信息 得分

    @PostMapping("/submit")
    CommonResponse<Integer>submitExam(@RequestBody @Valid CommonRequest<SubmitExamDTO> dto);




}

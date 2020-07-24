package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.pojo.dto.AnswerRecordTempInsertDTO;
import com.boss.xtrain.exam.pojo.dto.ExamStartAddRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPaperInfoQuery;
import com.boss.xtrain.exam.pojo.vo.ExamBasicInfoVO;
import com.boss.xtrain.exam.pojo.vo.ExamRecordIdVO;
import com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

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

    /**
     * 获取考试基本信息
     * @param request
     * @return
     */
    @PostMapping("/examInfo")
    CommonResponse<ExamBasicInfoVO> getExamBasicInfo(@RequestBody @Valid CommonRequest<ExamPaperInfoQuery> request);

    /**
     * 考试开始记录考试
     * @param request
     * @return
     */
    @PostMapping("/examRecord")
    CommonResponse<ExamRecordIdVO> createExamRecord(@RequestBody @Valid CommonRequest<ExamStartAddRecordDTO> request);

    /**
     * 暂时保存答案
     * @param request
     * @return
     */
    @PostMapping("/tempAnswers")
    CommonResponse<Integer> saveTempAnswers(@RequestBody @Valid CommonRequest<List<AnswerRecordTempInsertDTO>> request);


    @PostMapping("/submit")
    CommonResponse<Integer>submitExam(@RequestBody @Valid CommonRequest<SubmitExamDTO> dto);

    /**
     * 获取考试格式的试卷（没有正确答案标识，以免拦截请求泄露信息）
     * 如果redis存在，同时取出redis中的答案并合并
     *
     * @param request
     * @return
     */
    CommonResponse<PaperSubjectAnswerVO> getExamPaper(CommonRequest<SubmitExamDTO> request);


}

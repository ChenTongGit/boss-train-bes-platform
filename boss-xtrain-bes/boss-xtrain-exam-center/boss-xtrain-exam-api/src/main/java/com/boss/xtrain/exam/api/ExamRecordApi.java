package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordDetailQuery;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.vo.ExamRecordVO;
import com.boss.xtrain.exam.pojo.vo.test.PaperSubjectAnswerVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 答卷查询
 *
 * @author ChenTong
 * @date 2020/7/11 0:32
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamRecordApi {
    /**
     * 根据查询条件获取所有的考试记录 companyID
     * @author ChenTong
     * @param request
     * @return CommonResponse<CommonPage<ExamRecordVO>>
     * @date 2020/7/11 0:37
     */
    @PostMapping("/list")
    CommonResponse<CommonPage<ExamRecordVO>> findExamRecordByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<ExamRecordQuery>> request);

    /**
     * 通过考试记录id获取具体的答卷情况
     * @author ChenTong
     * @param request 
     * @return com.boss.xtrain.common.core.http.CommonResponse<AnserPaperDetailsVO>
     * @date 2020/7/11 0:41
     */
    @PostMapping("/answerPaperDetail")
    CommonResponse<PaperSubjectAnswerVO> findAnswerPaperDetail(@RequestBody @Valid CommonRequest<ExamRecordDetailQuery>request);
}

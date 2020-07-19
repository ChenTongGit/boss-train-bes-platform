package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;

import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**考试服务
 * @author lenovo
 */
@RequestMapping(value = "/education/bes/v1/exam")
public interface ExaminationApi {
    /**获得所有试卷简要信息
     * @return
     */
    @PostMapping(value = "/queryAllPaper")
    CommonResponse getAllPaper(CommonRequest<PaperQueryVO> commonRequest);

    /**获得某一试卷详细信息
     * @return
     */
    @PostMapping(value = "/queryOnePaper")
    CommonResponse getOnePaperWithSubject(CommonRequest<ExamPaperQuery> commonRequest);

    CommonResponse getOnePaperAnswer(CommonRequest<ExamPaperQuery> commonRequest);
}

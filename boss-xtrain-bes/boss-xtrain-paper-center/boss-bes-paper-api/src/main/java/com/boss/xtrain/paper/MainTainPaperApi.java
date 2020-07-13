package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.paper.vo.papermanage.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @version: V1.0
 * @className: MainTainPaperApi
 * @packageName: com.boss.bes.paper.api.paperapi
 * @description: 维护试卷模板API
 **/
@RequestMapping(value = "/education/bes/v1/paper/mainTainPaper")
public interface MainTainPaperApi {
    /**
     * @methodsName: getPaper
     * @description: 查询试卷集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryPaperList")
    public CommonResponse getPaper(@Valid CommonRequest<PaperQueryVO> commonRequest);
    /**
     * @methodsName: deleteOnePaper
     * @description: 删除试卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/deleteOnePaper")
    public CommonResponse deleteOnePaper(@Valid CommonRequest<DeletePaperVO> commonRequest);
    /**
     * @methodsName: deleteSomePaper
     * @description: 批量删除试卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/deleteSomePaper")
    public CommonResponse deleteSomePaper(@Valid CommonRequest<PaperListVO> commonRequest);
    /**
     * @methodsName: queryPaperDetail
     * @description: 查询题目以及答案集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/querySubjectList")
    public CommonResponse queryPaperDetail(@Valid CommonRequest<SubjectQueryVO> commonRequest);
    /**
     * @methodsName: updateSubjectList
     * @description: 更新题目集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/updateSubjectList")
    public CommonResponse updateSubjectList(@Valid CommonRequest<PaperUpdateVO> commonRequest);
}


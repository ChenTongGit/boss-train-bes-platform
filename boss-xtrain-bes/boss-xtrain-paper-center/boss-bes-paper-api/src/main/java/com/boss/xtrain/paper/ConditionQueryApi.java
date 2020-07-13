package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.paper.vo.conditionquerypaper.QueryPaperNameListVO;
import com.boss.xtrain.paper.vo.conditionquerypaper.QueryPaperVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @version: V1.0
 * @className: ConditionQueryApi
 * @packageName: com.boss.bes.paper.api.paperapi
 * @description: 条件查询试卷搜索框API
 * @data: 20:53 2020/4/1
 **/
@RequestMapping(value = "/education/bes/v1/paper/conditionQuery")
public interface ConditionQueryApi {
    /**
     * @methodsName: conditionQueryPaper
     * @description: 条件查询试卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryPaperByCondition")
    public CommonResponse conditionQueryPaper(@Valid CommonRequest<QueryPaperVO> commonRequest);
    /**
     * @methodsName: queryPaperNameTip
     * @description: 查询试卷名或模板名提示信息
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryPaperNameTip")
    public CommonResponse queryPaperNameTip(@Valid CommonRequest<QueryPaperNameListVO> commonRequest);
}


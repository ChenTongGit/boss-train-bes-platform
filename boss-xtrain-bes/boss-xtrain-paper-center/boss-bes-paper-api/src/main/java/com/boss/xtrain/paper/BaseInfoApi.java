package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.paper.vo.baseinfo.CombInfoQueryVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @version: V1.0
 * @className: BaseInfoApi
 * @packageName: com.boss.bes.paper.api.paperapi
 * @description: 试卷和题目基础信息API
 **/

@RequestMapping(value = "/education/bes/v1/paper/baseInfo")
public interface BaseInfoApi {
    /**
     * @methodsName: querySubjectCategoryList
     * @description: 获取题目类别集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/querySubjectCategoryList")
    CommonResponse querySubjectCategoryList(@Valid CommonRequest<CombInfoQueryVO> commonRequest);

    /**
     * @methodsName: querySubjectTypeList
     * @description: 获取题目题型集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/querySubjectTypeList")
    CommonResponse querySubjectTypeList(@Valid CommonRequest<CombInfoQueryVO> commonRequest);
    /**
     * @methodsName: queryPaperInfo
     * @description: 获取试卷类型或试卷难度或题目难度集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryPaperInfo")
    CommonResponse queryPaperInfo(@Valid CommonRequest<CombInfoQueryVO> commonRequest);
    /**
     * @methodsName: queryCompanyList
     * @description: 获取公司集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryCompanyList")
    CommonResponse queryCompanyList(@Valid CommonRequest<CombInfoQueryVO> commonRequest);

}

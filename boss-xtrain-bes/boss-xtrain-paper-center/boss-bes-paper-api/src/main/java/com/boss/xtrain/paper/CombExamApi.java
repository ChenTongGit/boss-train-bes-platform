package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.paper.vo.downloadtemplate.TemplateCombExamVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigItemQueryVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigQueryVO;
import com.boss.xtrain.paper.vo.fastcomb.CombExamVO;
import com.boss.xtrain.paper.vo.fastcomb.ConfigItemVO;
import com.boss.xtrain.paper.vo.papermanage.PaperQueryVO;
import com.boss.xtrain.paper.vo.standardcomb.StandardCombVO;
import com.boss.xtrain.paper.vo.templatemanage.TemplateQueryVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/education/bes/v1/paper/combExam")
public interface CombExamApi {
    /**
     * @methodsName: getPaper
     * @description: 试卷详情
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryPaperList")
    CommonResponse getPaper(@Valid CommonRequest<PaperQueryVO> commonRequest);
    /**
     * @methodsName: getTemplate
     * @description: 查询模板集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryTemplateList")
    CommonResponse getTemplate(@Valid CommonRequest<TemplateQueryVO> commonRequest);
    /**
     * @methodsName: downLoadTemplate
     * @description: 下载模板
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/downLoadTemplate")
    CommonResponse downLoadTemplate(@Valid CommonRequest<TemplateCombExamVO> commonRequest);
    /**
     * @methodsName: queryCombExamConfiguration
     * @description: 向基础服务获取组卷配置信息集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryCombExamConfiguration")
    CommonResponse queryCombExamConfiguration(@Valid CommonRequest<CombConfigQueryVO> commonRequest);
    /**
     * @methodsName: queryConfigItemsList
     * @description: 向基础服务获取组卷配置的配置信息
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryConfigItemsList")
    CommonResponse queryConfigItemsList(@Valid CommonRequest<CombConfigItemQueryVO> commonRequest);
    /**
     * @methodsName: fastCombExam
     * @description: 查看组卷配置信息界面快速组卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/fastCombExam")
    CommonResponse fastCombExam(@Valid CommonRequest<CombExamVO> commonRequest);
    /**
     * @methodsName: saveCombExamItemList
     * @description: 保存配置明细集合
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/saveCombExamItemList")
    CommonResponse saveCombExamItemList(@Valid CommonRequest<List<ConfigItemVO>> commonRequest);
    /**
     * @methodsName: fastCombExamById
     * @description: 组卷配置界面的快速组卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/fastCombExamById")
    CommonResponse fastCombExamById(@Valid CommonRequest<CombConfigItemQueryVO> commonRequest);
    /**
     * @methodsName: standardCombExam
     * @description: 标准组卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/standardCombExam")
    CommonResponse standardCombExam(@Valid CommonRequest<StandardCombVO> commonRequest);
}


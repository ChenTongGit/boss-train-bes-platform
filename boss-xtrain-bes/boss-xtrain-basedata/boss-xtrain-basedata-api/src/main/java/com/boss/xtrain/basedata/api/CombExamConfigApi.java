package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.api.paper.CombConfigQueryDTO;
import com.boss.xtrain.basedata.api.paper.CombConfigVO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.basedata.pojo.vo.combexamconfig.*;
import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemQueryVO;
import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/combExamConfig")
@CrossOrigin
public interface CombExamConfigApi {
    /**
     * 获取组卷配置（分页）
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryExamConfigPage")
    CommonResponse<CommonPage<CombExamConfigVO>> queryExamConfig(CommonRequest<CombExamConfigQueryVO> commonRequest);

    /**
     * 根据配置项id获取组卷配置明细
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryExamItem")
    CommonResponse<List<CombExamItemVO>> queryExamItemById(CommonRequest<CombExamItemQueryVO> commonRequest);

    /**
     * 删除组卷配置
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteConfig")
    CommonResponse<Boolean> deleteExamConfig(CommonRequest<CombExamConfigDeleteVO> commonRequest);

    /**
     * 删除组卷配置
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteConfigs")
    CommonResponse<Boolean> deleteExamConfigs(CommonRequest<CombExamConfigDeleteIdsVO> commonRequest);
    /**
     * 增加组卷配置
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertExamConfig")
    CommonResponse<CombExamConfigVO> insertExamConfig(CommonRequest<CombExamConfigVO> commonRequest);

    /**
     * 更新组卷配置
     * @param commonRequest
     * @return
     */
    @PostMapping("/updateExamConfig")
    CommonResponse<CombExamConfigUpdateVO> updateExamConfig(CommonRequest<CombExamConfigUpdateVO> commonRequest);

    /**
     * 添加组卷配置明细
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertExamItem")
    CommonResponse<List<CombExamItemVO>> insertExamItem(CommonRequest<List<CombExamItemVO>> commonRequest);

    /**
     * 获取题目数量
     * @param commonRequest
     * @return
     */
    @PostMapping("/querySubjectCount")
    CommonResponse<Integer> querySubjectCount(CommonRequest<CombExamItemVO> commonRequest);


    @PostMapping("/queryConfig")
    PageInfo<CombConfigVO> queryCombExamConfiguration(CombConfigQueryDTO combConfigQueryDTO);
}

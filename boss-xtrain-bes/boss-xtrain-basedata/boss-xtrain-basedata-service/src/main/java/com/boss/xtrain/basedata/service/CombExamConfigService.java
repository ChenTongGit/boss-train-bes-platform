package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.*;


import java.util.List;

/**
 * @author guo xinrui
 * @description 组卷service
 * @date 2020/07/08
 */
public interface CombExamConfigService{

    /**
     * 插入组卷
     * @param combExamConfigDTO
     */
    void insertConfig(CombExamConfigDTO combExamConfigDTO);

    /**
     * 删除组卷
     * @param combExamConfigDeleteDTO
     */
    void deleteConfig(CombExamConfigDeleteDTO combExamConfigDeleteDTO);

    /**
     * 批量删除组卷
     * @param combExamConfigDeleteIdsDTO
     */
    void deleteConfigs(CombExamConfigDeleteIdsDTO combExamConfigDeleteIdsDTO);

    /**
     * 更新组卷
     * @param combExamConfigUpdateDTO
     */
    void updateConfig(CombExamConfigUpdateDTO combExamConfigUpdateDTO);

    /**
     * 提供给试卷查询组卷
     * @param combExamConfigQueryDTO
     * @return
     */
    List<CombExamConfigDTO> queryConfig(CombExamConfigQueryDTO combExamConfigQueryDTO);

    /**
     * 查询组卷
     * @param combExamConfigQueryDTO
     * @return
     */
    List<CombExamConfigDTO> queryExamConfig(CombExamConfigQueryDTO combExamConfigQueryDTO);

    /**
     * 根据组卷查询组卷详情
     * @param combExamItemQueryDTO
     * @return
     */
    List<CombExamItemDTO> queryItem(CombExamItemQueryDTO combExamItemQueryDTO);

    /**
     * 批量插入详情
     * @param itemList
     * @return
     */
    boolean insertItem(List<CombExamItemDTO> itemList);

    /**
     * 检查名称重复
     * @param combExamConfigDto
     */
    void checkRepeatName(CombExamConfigDTO combExamConfigDto);


}

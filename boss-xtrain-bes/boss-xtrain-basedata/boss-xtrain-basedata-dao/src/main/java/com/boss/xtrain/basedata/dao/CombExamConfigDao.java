package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类别dao
 * @date 2020/07/08
 */
public interface CombExamConfigDao {

    /**
     * 插入组卷
     * @param combExamConfig
     * @return
     */
    int insertCombExamConfig(CombExamConfig combExamConfig);

    /**
     * 删除组卷
     * @param example
     * @return
     */
    int deleteCombExamConfig(Example example);

    /**
     * 批量删除组卷
     * @param idList
     * @return
     */
    int deleteCombExamConfigByIds(List<Long> idList);

    /**
     * 更新组卷
     * @param c
     */
    void updateCombExamConfig(CombExamConfig c);

    /**
     * 查询组卷
     * @param combExamConfigQueryDTO
     * @return
     */
    List<CombExamConfig> queryCombExamConfig(CombExamConfigQueryDTO combExamConfigQueryDTO);

    /**
     * 提供给试卷查询组卷
     * @param combExamConfigQueryDTO
     * @return
     */
    List<CombExamConfig> queryCombExamConfigTest(CombExamConfigQueryDTO combExamConfigQueryDTO);

    /**
     * 检查组卷名称是否重复
     * @param example
     * @return
     */
    int checkRepeatName(Example example);

}

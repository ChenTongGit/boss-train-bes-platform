package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface CombExamConfigDao {

    int insertCombExamConfig(CombExamConfig combExamConfig);

    int deleteCombExamConfig(Example example);

    int deleteCombExamConfigByIds(List<Long> idList);

    void updateCombExamConfig(CombExamConfig c);

    List<CombExamConfigDTO> getCombExamConfig(Example example);

    int checkRepeatName(Example example);

}

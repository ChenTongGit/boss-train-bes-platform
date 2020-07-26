package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CombExamConfigMapper extends BaseMapper<CombExamConfig> {

    int updateCombConfig(CombExamConfig combExamConfig);

}
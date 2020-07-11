package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CombExamConfigDao;
import com.boss.xtrain.basedata.mapper.CombExamConfigMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.common.util.PojoUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

public class CombExamConfigDapImpl implements CombExamConfigDao {

    private CombExamConfigMapper combExamConfigMapper;

    @Override
    public int insertCombExamConfig(CombExamConfig combExamConfig) {
        return combExamConfigMapper.insert(combExamConfig);
    }

    @Override
    public int deleteCombExamConfig(Example example) {
        return combExamConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteCombExamConfigByIds(List<Long> idList) {
        Example example = new Example(CombExamConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",idList);
        return combExamConfigMapper.deleteByExample(example);
    }

    @Override
    public void updateCombExamConfig(CombExamConfig combExamConfig) {
        Example example = new Example(CombExamConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",combExamConfig .getId());
        combExamConfigMapper.updateByExampleSelective(combExamConfig,example);

    }

    @Override
    public List<CombExamConfigDTO> getCombExamConfig(Example example) {
        List<CombExamConfig> combExamConfigs = new ArrayList<>();
        List<CombExamConfigDTO> combExamConfigDTOS = new ArrayList<>();
        PojoUtils.copyProperties(combExamConfigs,combExamConfigDTOS);
        return combExamConfigDTOS;
    }

    @Override
    public int checkRepeatName(Example example) {
        return combExamConfigMapper.deleteByExample(example);
    }
}

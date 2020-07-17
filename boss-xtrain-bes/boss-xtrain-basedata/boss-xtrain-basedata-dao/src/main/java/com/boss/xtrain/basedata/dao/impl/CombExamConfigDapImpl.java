package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CombExamConfigDao;
import com.boss.xtrain.basedata.mapper.CombExamConfigMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CombExamConfigDapImpl implements CombExamConfigDao {

    @Autowired
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
        combExamConfigMapper.updateCombConfig(combExamConfig);
    }

    @Override
    public List<CombExamConfigDTO> getAll(Example example) {
        List<CombExamConfig> combExamConfigs = combExamConfigMapper.selectByExample(example);
        List<CombExamConfigDTO> combExamConfigDTOS = PojoUtils.copyListProperties(combExamConfigs,CombExamConfigDTO::new);
        return combExamConfigDTOS;
    }

    @Override
    public List<CombExamConfig> queryCombExamConfig(CombExamConfigQueryDTO combExamConfigQueryDTO) {
        Example example = new Example(CombExamConfig.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",combExamConfigQueryDTO.getOrgId());
        criteria.andLike("name","%"+combExamConfigQueryDTO.getName()+"%");
        return combExamConfigMapper.selectByExample(example);

    }

    @Override
    public int checkRepeatName(Example example) {
        return combExamConfigMapper.selectCountByExample(example);
    }
}

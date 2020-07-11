package com.boss.xtrain.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.basedata.mapper.CombExamConfigMapper;
import com.boss.xtrain.basedata.service.CombExamConfigService;

public class CombExamConfigServiceImpl implements CombExamConfigService{

    @Resource
    private CombExamConfigMapper combExamConfigMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return combExamConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CombExamConfig record) {
        return combExamConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(CombExamConfig record) {
        return combExamConfigMapper.insertSelective(record);
    }

    @Override
    public CombExamConfig selectByPrimaryKey(Long id) {
        return combExamConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CombExamConfig record) {
        return combExamConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CombExamConfig record) {
        return combExamConfigMapper.updateByPrimaryKey(record);
    }

}

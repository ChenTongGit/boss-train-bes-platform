package com.boss.xtrain.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.mapper.CombExamItemMapper;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.basedata.service.CombExamItemService;
@Service
public class CombExamItemServiceImpl implements CombExamItemService{

    @Resource
    private CombExamItemMapper combExamItemMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return combExamItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CombExamItem record) {
        return combExamItemMapper.insert(record);
    }

    @Override
    public int insertSelective(CombExamItem record) {
        return combExamItemMapper.insertSelective(record);
    }

    @Override
    public CombExamItem selectByPrimaryKey(Long id) {
        return combExamItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CombExamItem record) {
        return combExamItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CombExamItem record) {
        return combExamItemMapper.updateByPrimaryKey(record);
    }

}

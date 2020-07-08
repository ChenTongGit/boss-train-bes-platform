package com.boss.xtrain.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.mapper.DictionaryMapper;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import com.boss.xtrain.basedata.service.DictionaryService;
@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dictionaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Dictionary record) {
        return dictionaryMapper.insert(record);
    }

    @Override
    public int insertSelective(Dictionary record) {
        return dictionaryMapper.insertSelective(record);
    }

    @Override
    public Dictionary selectByPrimaryKey(Long id) {
        return dictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKey(record);
    }

}

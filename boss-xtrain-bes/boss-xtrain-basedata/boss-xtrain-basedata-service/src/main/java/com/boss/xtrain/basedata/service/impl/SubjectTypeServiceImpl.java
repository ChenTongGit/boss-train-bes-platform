package com.boss.xtrain.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.basedata.mapper.SubjectTypeMapper;
import com.boss.xtrain.basedata.service.SubjectTypeService;
@Service
public class SubjectTypeServiceImpl implements SubjectTypeService{

    @Resource
    private SubjectTypeMapper subjectTypeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return subjectTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SubjectType record) {
        return subjectTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(SubjectType record) {
        return subjectTypeMapper.insertSelective(record);
    }

    @Override
    public SubjectType selectByPrimaryKey(Long id) {
        return subjectTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SubjectType record) {
        return subjectTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SubjectType record) {
        return subjectTypeMapper.updateByPrimaryKey(record);
    }

}

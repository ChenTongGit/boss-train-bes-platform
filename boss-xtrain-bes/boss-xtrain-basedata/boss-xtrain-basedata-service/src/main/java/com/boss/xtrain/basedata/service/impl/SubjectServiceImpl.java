package com.boss.xtrain.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.mapper.SubjectMapper;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import com.boss.xtrain.basedata.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService{

    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return subjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Subject record) {
        return subjectMapper.insert(record);
    }

    @Override
    public int insertSelective(Subject record) {
        return subjectMapper.insertSelective(record);
    }

    @Override
    public Subject selectByPrimaryKey(Long id) {
        return subjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Subject record) {
        return subjectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Subject record) {
        return subjectMapper.updateByPrimaryKey(record);
    }

}

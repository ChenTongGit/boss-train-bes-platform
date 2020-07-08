package com.boss.xtrain.basedata.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.basedata.mapper.SubjectAnswerMapper;
import com.boss.xtrain.basedata.service.SubjectAnswerService;
@Service
public class SubjectAnswerServiceImpl implements SubjectAnswerService{

    @Resource
    private SubjectAnswerMapper subjectAnswerMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return subjectAnswerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SubjectAnswer record) {
        return subjectAnswerMapper.insert(record);
    }

    @Override
    public int insertSelective(SubjectAnswer record) {
        return subjectAnswerMapper.insertSelective(record);
    }

    @Override
    public SubjectAnswer selectByPrimaryKey(Long id) {
        return subjectAnswerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SubjectAnswer record) {
        return subjectAnswerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SubjectAnswer record) {
        return subjectAnswerMapper.updateByPrimaryKey(record);
    }

}

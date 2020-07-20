package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.SubjectAnswerDao;
import com.boss.xtrain.basedata.mapper.SubjectAnswerMapper;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectAnswerDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectDTO;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectAnswerDaoImpl implements SubjectAnswerDao {

    @Autowired
    private SubjectAnswerMapper answerMapper;

    @Override
    public int insertAnswer(List<SubjectAnswer> subjectAnswers) {
        return answerMapper.insertBatch(subjectAnswers);
    }

    @Override
    public int deleteAnswer(Long subjectId) {
        Example example = new Example(SubjectAnswer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("subjectId",subjectId);
        return answerMapper.deleteByExample(example);

    }

    @Override
    public void deleteAnswerList(List<Long> idList) {
        Example example = new Example(SubjectAnswer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("subjectId",idList);
        answerMapper.deleteByExample(example);
    }

    @Override
    public void updateAnswer(SubjectAnswer subjectAnswer) {
        answerMapper.updateByPrimaryKey(subjectAnswer);
    }

    @Override
    public List<SubjectAnswerDTO> queryAnswer(Example example) {
        List<SubjectAnswer> subjectAnswers = answerMapper.selectByExample(example);
        List<SubjectAnswerDTO> subjectAnswerDTOS = PojoUtils.copyListProperties(subjectAnswers,SubjectAnswerDTO::new);
        return subjectAnswerDTOS;

    }

    @Override
    public List<SubjectAnswer> queryAnswerList(Long id) {
        Example example = new Example(SubjectAnswer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("subjectId",id);
        return answerMapper.selectByExample(example);

    }

}

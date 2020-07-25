package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.SubjectAnswerDao;
import com.boss.xtrain.basedata.mapper.SubjectAnswerMapper;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectAnswerDTO;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目答案dao
 * @date 2020/07/08
 */
@Repository
public class SubjectAnswerDaoImpl implements SubjectAnswerDao {

    @Autowired
    private SubjectAnswerMapper answerMapper;

    private String SUBJECT = "subjectId";

    @Override
    public int insertAnswer(List<SubjectAnswer> subjectAnswers) {
        return answerMapper.insertBatch(subjectAnswers);
    }

    @Override
    public int deleteAnswer(Long subjectId) {
        Example example = new Example(SubjectAnswer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(SUBJECT,subjectId);
        return answerMapper.deleteByExample(example);

    }

    @Override
    public void deleteAnswerList(List<Long> idList) {
        Example example = new Example(SubjectAnswer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn(SUBJECT,idList);
        answerMapper.deleteByExample(example);
    }

    @Override
    public void updateAnswer(SubjectAnswer subjectAnswer) {
        answerMapper.updateByPrimaryKey(subjectAnswer);
    }

    @Override
    public List<SubjectAnswerDTO> queryAnswer(Example example) {
        List<SubjectAnswer> subjectAnswers = answerMapper.selectByExample(example);
        return PojoUtils.copyListProperties(subjectAnswers,SubjectAnswerDTO::new);

    }

    @Override
    public List<SubjectAnswer> queryAnswerList(Long id) {
        Example example = new Example(SubjectAnswer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(SUBJECT,id);
        return answerMapper.selectByExample(example);

    }

}

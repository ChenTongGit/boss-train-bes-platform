package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.SubjectDao;
import com.boss.xtrain.basedata.mapper.SubjectAnswerMapper;
import com.boss.xtrain.basedata.mapper.SubjectMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private SubjectAnswerMapper subjectAnswerMapper;

    @Override
    public int insertSubject(SubjectInsertDTO subjectInsertDTO) {
        Subject subject = new Subject();
        subject.setCategoryId(subjectMapper.queryCategoryIdByCategoryName(subjectInsertDTO.getCategoryName()));
        subject.setSubjectTypeId(subjectMapper.querySubjectTypeIdBySubjectTypeName(subjectInsertDTO.getSubjectTypeName()));
        PojoUtils.copyProperties(subject,subjectInsertDTO);
        int result = subjectMapper.insertSelective(subject);
        List<SubjectAnswer> answers = subjectInsertDTO.getSubjectAnswers();
        for(SubjectAnswer subjectAnswer : answers){
            long nid= idWorker.nextId();
            subjectAnswer.setId(nid);
            subjectAnswer.setSubjectId(subjectInsertDTO.getId());
            subjectAnswerMapper.insertSelective(subjectAnswer);
        }
        return result;
    }

    @Override
    public int deleteSubject(SubjectDeleteDTO subjectDeleteDTO) {
        Subject subject = new Subject();
        PojoUtils.copyProperties(subject,subjectDeleteDTO);
        subjectMapper.deleteSubjectAnswer(subject.getId());
        return subjectMapper.deleteByPrimaryKey(subject);
    }

    @Override
    public SubjectDTO update(SubjectUpdateDTO subjectUpdateDTO) {
        subjectUpdateDTO.setVersion(subjectUpdateDTO.getVersion()+1L);
        Subject subject = new Subject();
        PojoUtils.copyProperties(subject,subjectUpdateDTO);
        subject.setCategoryId(subjectMapper.queryCategoryIdByCategoryName(subjectUpdateDTO.getCategoryName()));
        subject.setSubjectTypeId(subjectMapper.querySubjectTypeIdBySubjectTypeName(subjectUpdateDTO.getSubjectTypeName()));
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", subjectUpdateDTO.getId());
        criteria.andEqualTo("version", subjectUpdateDTO.getVersion()-1L);
        int update = subjectMapper.updateByExampleSelective(subject,example);
        return null;
    }

    @Override
    public List<SubjectDTO> queryByCondition(SubjectQueryDTO subjectQueryDTO) {
        return subjectMapper.querySubjectByCondition(subjectQueryDTO);
    }

    @Override
    public List<SubjectDTO> quickMakePaper(CombExamItemDTO combExamItemDTO) {
        return subjectMapper.quickMakePaper(combExamItemDTO);
    }

    @Override
    public SubjectDTO getSubjectById(Long id) {
        return subjectMapper.getSubjectById(id);
    }
}

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
import org.apache.poi.ss.formula.functions.PPMT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private SubjectAnswerMapper subjectAnswerMapper;


    @Override
    public int insertSubject(Subject subject) {
        return subjectMapper.insert(subject);
    }

    @Override
    public int deleteSubject(Example example) {
        return subjectMapper.deleteByExample(example);
    }

    @Override
    public int deleteSubject(List<Long> ids) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return subjectMapper.deleteByExample(example);
    }

    @Override
    public int update(Subject subject) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",subject.getId());
        criteria.andEqualTo("version",subject.getVersion());
        return subjectMapper.updateByExampleSelective(subject,example);

    }

    @Override
    public List<SubjectDTO> queryAll() {
        List<Subject> subjects = subjectMapper.selectAll();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        PojoUtils.copyProperties(subjects,subjectDTOS);
        return subjectDTOS;

    }

    @Override
    public List<SubjectDTO> queryByCondition(Long orgId, String subjectName, String categoryName, String typeName) {
        List<Subject> subjects = subjectMapper.queryByCondition(orgId,subjectName,categoryName,typeName);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        PojoUtils.copyProperties(subjects,subjectDTOS);
        return subjectDTOS;
    }

    @Override
    public List<Subject> querySubject(CombExamItemDTO combExamItemDTO) {
        Long categoryId = combExamItemDTO.getCategoryId();
        Long subjectTypeId =combExamItemDTO.getSubjectTypeId();
        Long difficulty = combExamItemDTO.getDifficulty();
        return subjectMapper.querySubject(categoryId,subjectTypeId,difficulty);

    }

    @Override
    public List<Subject> querySubjectRandom(CombExamItemDTO combExamItemDTO, Integer num) {
        Long categoryId = combExamItemDTO.getCategoryId();
        Long subjectTypeId = combExamItemDTO.getSubjectTypeId();
        Long difficulty = combExamItemDTO.getDifficulty();
        return subjectMapper.queryByRandom(categoryId,subjectTypeId,difficulty,num);

    }

    @Override
    public List<SubjectDTO> queryExamSubject(Long orgId, Long subjectTypeId) {
        List<Subject> subjects = subjectMapper.getExamSubject(orgId,subjectTypeId);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        PojoUtils.copyProperties(subjects,SubjectDTO.class);
        return subjectDTOS;

    }

    @Override
    public SubjectDTO querySubjectById(Long id) {
        Subject subject = subjectMapper.getSubjectById(id);
        SubjectDTO subjectDto = new SubjectDTO();
        PojoUtils.copyProperties(subject,subjectDto);
        return subjectDto;

    }

    @Override
    public List<String> queryCategoryById(List<Long> subjectIds) {
        return subjectMapper.queryCategoryById(subjectIds);
    }

    @Override
    public Integer countSubject(Example example) {
        return subjectMapper.selectCountByExample(example);
    }

    @Override
    public int queryNameCount(Example example) {
        return subjectMapper.selectCountByExample(example);
    }
}

package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.SubjectDao;
import com.boss.xtrain.basedata.mapper.*;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.*;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目dao
 * @date 2020/07/08
 */
@Repository
@Slf4j
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private SubjectAnswerMapper subjectAnswerMapper;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SubjectTypeMapper subjectTypeMapper;


    @Override
    public int insertSubject(Subject subject) {
        subject.setStatus(1);
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
    public int updateSubject(Subject subject) {
        log.info("subject:{}",subject.toString());
        return subjectMapper.updateByPrimaryKey(subject);
    }

    @Override
    public List<SubjectDTO> queryAll() {
        List<Subject> subjects = subjectMapper.selectAll();
        List<SubjectDTO> subjectDTOS = PojoUtils.copyListProperties(subjects,SubjectDTO::new);
        int count = 0;
        for (Subject subject : subjects){
            Category category = categoryMapper.selectByPrimaryKey(subject.getCategoryId());
            SubjectType subjectType = subjectTypeMapper.selectByPrimaryKey(subject.getSubjectTypeId());

            subjectDTOS.get(count).setSubjectTypeName(subjectType.getName());
            subjectDTOS.get(count).setCategoryName(category.getName());

            count++;

        }
        log.info(subjectDTOS.toString());
        return subjectDTOS;
    }

    @Override
    public SubjectDTO querySubjectOtherInfo(Long id) {
        Subject subject = subjectMapper.getSubjectById(id);
        SubjectDTO subjectDTO = new SubjectDTO();
        PojoUtils.copyProperties(subject,subjectDTO);
        return subjectDTO;
    }

    @Override
    public List<SubjectDTO> queryByCondition(Example example) {
        List<Subject> subjects = subjectMapper.selectByExample(example);
        return PojoUtils.copyListProperties(subjects,SubjectDTO::new);
    }

    @Override
    public List<DifficultDTO> queryDifficult(Example example) {
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
        return PojoUtils.copyListProperties(dictionaries,DifficultDTO::new);
    }

    @Override
    public List<String> querySubjectDifficult(Example example) {
        List<Subject> subjects = subjectMapper.selectByExample(example);
        List<String> difficulties = new ArrayList<>();
        for (Subject subject : subjects){
            difficulties.add(subject.getDifficulty());
        }
        return difficulties;
    }


    @Override
    public List<Long> queryCategoryIdByName(Example example) {
        List<Category> categories = categoryMapper.selectByExample(example);
        List<Long> ids = new ArrayList<>();
        for (Category category :categories){
            ids.add(category.getId());
        }
        return ids;
    }

    @Override
    public List<Long> queryTypeIdByName(Example example) {
        List<SubjectType> subjectTypes = subjectTypeMapper.selectByExample(example);
        List<Long> ids = new ArrayList<>();
        for (SubjectType subjectType : subjectTypes){
            ids.add(subjectType.getId());
        }
        return ids;
    }


    @Override
    public List<Subject> querySubject(CombExamItemDTO combExamItemDTO) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",combExamItemDTO.getCategoryId());
        criteria.andEqualTo("subjectTypeId",combExamItemDTO.getSubjectTypeId());
        criteria.andEqualTo("difficulty",combExamItemDTO.getDifficultyName());
        log.info(subjectMapper.selectByExample(example).toString());
        return subjectMapper.selectByExample(example);

    }

    @Override
    public List<Subject> querySubjectRandom(CombExamItemDTO combExamItemDTO, Integer num) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",combExamItemDTO.getCategoryId());
        criteria.andEqualTo("subjectTypeId",combExamItemDTO.getSubjectTypeId());
        criteria.andEqualTo("difficulty",combExamItemDTO.getDifficultyName());
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List<SubjectDTO> queryExamSubject(Long orgId, Long subjectTypeId) {
        List<Subject> subjects = subjectMapper.getExamSubject(orgId,subjectTypeId);
        return PojoUtils.copyListProperties(subjects,SubjectDTO::new);

    }

    @Override
    public SubjectDTO querySubjectById(Long id) {
        Subject subject = subjectMapper.getSubjectById(id);
        SubjectDTO subjectDto = new SubjectDTO();
        PojoUtils.copyProperties(subject,subjectDto);
        return subjectDto;

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

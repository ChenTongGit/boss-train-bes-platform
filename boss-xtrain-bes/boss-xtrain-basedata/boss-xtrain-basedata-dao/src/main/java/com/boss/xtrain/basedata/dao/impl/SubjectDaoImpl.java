package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.SubjectDao;
import com.boss.xtrain.basedata.mapper.*;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.*;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.PPMT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

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
        return subjectMapper.updateByPrimaryKey(subject);
    }

    @Override
    public List<SubjectDTO> queryAll() {
        List<Subject> subjects = subjectMapper.selectAll();
        List<SubjectDTO> subjectDTOS = PojoUtils.copyListProperties(subjects,SubjectDTO::new);
        List<Category> categories = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (Subject subject : subjects){
            categories.add(count1,categoryMapper.selectByPrimaryKey(subject.getCategoryId()));
            count1++;
        }
        List<SubjectType> subjectTypes = new ArrayList<>();
        for (Subject subject : subjects){
            subjectTypes.add(count2,subjectTypeMapper.selectByPrimaryKey(subject.getSubjectTypeId()));
            count2++;
        }
        log.info(subjects.toString());

        for (SubjectDTO subjectDTO : subjectDTOS){
            subjectDTO.setName(subjects.get(count3).getName());
            subjectDTO.setCategoryName(categories.get(count3).getName());
            subjectDTO.setSubjectTypeName(subjectTypes.get(count3).getName());
            count3++;
        }

        log.info(subjectDTOS.toString());
        return subjectDTOS;
    }


    @Override
    public List<SubjectDTO> querySubjectOtherInfo(Example example){
        List<Subject> subjects = subjectMapper.selectByExample(example);
        List<SubjectDTO> subjectDTOS = PojoUtils.copyListProperties(subjects,SubjectDTO::new);
        return subjectDTOS;
    }

    @Override
    public List<SubjectDTO> queryByCondition(Long orgId, String subjectName, String categoryName, String typeName) {
        List<Subject> subjects = subjectMapper.queryByCondition(orgId,subjectName,categoryName,typeName);
        List<SubjectDTO> subjectDTOS = PojoUtils.copyListProperties(subjects,SubjectDTO::new);
        return subjectDTOS;
    }

    @Override
    public List<DifficultDTO> queryDifficult(Example example) {
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
        List<DifficultDTO> difficultDTOS = PojoUtils.copyListProperties(dictionaries,DifficultDTO::new);

        return difficultDTOS;
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
        Long categoryId = combExamItemDTO.getCategoryId();
        Long subjectTypeId = combExamItemDTO.getSubjectTypeId();
        String difficulty = combExamItemDTO.getDifficultyName();
        log.info(categoryId.toString());
        log.info(subjectTypeId.toString());
        log.info(difficulty);
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",combExamItemDTO.getCategoryId());
        criteria.andEqualTo("subjectTypeId",combExamItemDTO.getSubjectTypeId());
        criteria.andEqualTo("difficulty",combExamItemDTO.getDifficultyName());
        return subjectMapper.selectByExample(example);//queryByRandom(categoryId,subjectTypeId,difficulty,num);

    }

    @Override
    public List<SubjectDTO> queryExamSubject(Long orgId, Long subjectTypeId) {
        List<Subject> subjects = subjectMapper.getExamSubject(orgId,subjectTypeId);
        List<SubjectDTO> subjectDTOS = PojoUtils.copyListProperties(subjects,SubjectDTO::new);
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

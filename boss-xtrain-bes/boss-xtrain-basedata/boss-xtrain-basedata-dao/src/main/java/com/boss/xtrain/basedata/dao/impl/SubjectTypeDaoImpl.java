package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.SubjectTypeDao;
import com.boss.xtrain.basedata.mapper.SubjectTypeMapper;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.*;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class SubjectTypeDaoImpl implements SubjectTypeDao{

    @Autowired
    private SubjectTypeMapper subjectTypeMapper;

    @Override
    public int insertSubjectType(SubjectType subjectType) {
        return subjectTypeMapper.insert(subjectType);
    }

    @Override
    public int deleteSubjectType(Example example) {
        return subjectTypeMapper.deleteByExample(example);
    }

    @Override
    public int updateSubjectType(SubjectType subjectType) {
        log.info("sql",this.subjectTypeMapper.updateSubjectType(subjectType));
        return subjectTypeMapper.updateSubjectType(subjectType);
    }

    @Override
    public List<SubjectType> queryAll() {
        return subjectTypeMapper.selectAll();
    }

    @Override
    public List<String> queryTypeNameById(Example example){
        List<SubjectType> subjectTypes = subjectTypeMapper.selectByExample(example);
        List<String> names = new ArrayList<>();
        for (SubjectType subjectType : subjectTypes){
            names.add(subjectType.getName());
        }
        return names;
    }

    @Override
    public List<SubjectTypeDTO> queryByCondition(Example example) {
        List<SubjectType> subjectTypes = subjectTypeMapper.selectByExample(example);
        List<SubjectTypeDTO> subjectTypeDTOS = PojoUtils.copyListProperties(subjectTypes,SubjectTypeDTO::new);
        return subjectTypeDTOS;
    }

    @Override
    public int checkRepeatName(Example example) {
        return subjectTypeMapper.selectCountByExample(example);
    }
}

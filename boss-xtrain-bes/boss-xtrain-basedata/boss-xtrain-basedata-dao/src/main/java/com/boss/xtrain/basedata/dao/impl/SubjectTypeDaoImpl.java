package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.SubjectTypeDao;
import com.boss.xtrain.basedata.mapper.SubjectTypeMapper;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.*;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
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
    public int updateSubjectType(SubjectType subjectType, Example example) {
        return subjectTypeMapper.updateByExampleSelective(subjectType,example);
    }

    @Override
    public List<SubjectTypeDTO> queryByCondition(Example example) {
        List<SubjectType> subjectTypes = subjectTypeMapper.selectByExample(example);
        List<SubjectTypeDTO> subjectTypeDTOS = new ArrayList<>();
        PojoUtils.copyProperties(subjectTypes,subjectTypeDTOS);
        return subjectTypeDTOS;
    }

    @Override
    public SubjectType getSubjectTypes(Long id) {
        return subjectTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int checkRepeatName(Example example) {
        return subjectTypeMapper.selectCountByExample(example);
    }
}

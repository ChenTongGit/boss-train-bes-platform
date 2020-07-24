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
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类型dao
 * @date 2020/07/08
 */
@Repository
@Slf4j
public class SubjectTypeDaoImpl implements SubjectTypeDao{

    @Autowired
    private SubjectTypeMapper subjectTypeMapper;

    @Override
    public int insertSubjectType(SubjectType subjectType) {
        subjectType.setStatus(1);
        return subjectTypeMapper.insert(subjectType);
    }

    @Override
    public int deleteSubjectType(Example example) {
        return subjectTypeMapper.deleteByExample(example);
    }

    @Override
    public int updateSubjectType(SubjectType subjectType) {
        return subjectTypeMapper.updateSubjectType(subjectType);
    }

    @Override
    public List<SubjectType> queryAll() {
        return subjectTypeMapper.selectAll();
    }

    @Override
    public List<SubjectTypeDTO> queryByCondition(Example example) {
        List<SubjectType> subjectTypes = subjectTypeMapper.selectByExample(example);
        return PojoUtils.copyListProperties(subjectTypes,SubjectTypeDTO::new);
    }

    @Override
    public int checkRepeatName(Example example) {
        return subjectTypeMapper.selectCountByExample(example);
    }

    @Override
    public SubjectType queryTypeById(Long id) {
        return subjectTypeMapper.selectByPrimaryKey(id);
    }
}

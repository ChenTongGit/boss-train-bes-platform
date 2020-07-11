package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeListConditionDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeListDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectTypeMapper extends BaseMapper<SubjectType> {
    /**
     * 题目类型元素列表
     * @param subjectTypeQueryDTO
     * @return
     */
    List<SubjectTypeDTO> queryByCondition(SubjectTypeQueryDTO subjectTypeQueryDTO);
    /**
     * 试卷服务获取题目类型列表
     * @param subjectTypeListConditionDTO
     * @return
     */
    List<SubjectTypeListDTO> getSubjectTypes(SubjectTypeListConditionDTO subjectTypeListConditionDTO);
}
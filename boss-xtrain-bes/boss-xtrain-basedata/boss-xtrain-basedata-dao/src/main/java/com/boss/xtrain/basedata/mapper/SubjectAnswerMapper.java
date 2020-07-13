package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectAnswerMapper extends BaseMapper<SubjectAnswer> {
    /**
     * 批量插入答案
     * @param itemList
     * @return
     */
    Integer insertBatch(@Param("itemList") List<SubjectAnswer> itemList);


}
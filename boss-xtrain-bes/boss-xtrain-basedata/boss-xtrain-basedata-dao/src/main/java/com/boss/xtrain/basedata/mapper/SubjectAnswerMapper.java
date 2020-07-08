package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectAnswerMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(SubjectAnswer record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SubjectAnswer record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SubjectAnswer selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SubjectAnswer record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SubjectAnswer record);
}
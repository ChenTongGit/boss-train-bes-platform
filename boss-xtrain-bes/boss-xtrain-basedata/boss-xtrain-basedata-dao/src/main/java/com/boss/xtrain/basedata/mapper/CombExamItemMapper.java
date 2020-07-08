package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CombExamItemMapper {
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
    int insert(CombExamItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CombExamItem record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CombExamItem selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CombExamItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CombExamItem record);
}
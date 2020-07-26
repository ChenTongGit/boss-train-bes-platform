package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;


@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    int insertDictionaryList(@Param("dictionaries") List<Dictionary> dictionaries);

}
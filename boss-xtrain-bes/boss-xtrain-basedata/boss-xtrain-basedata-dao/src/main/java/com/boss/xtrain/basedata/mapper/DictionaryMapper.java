package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.websocket.server.PathParam;
import java.util.List;


@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    int insertDictionaryList(@Param("dictionaries") List<Dictionary> dictionaries);

}
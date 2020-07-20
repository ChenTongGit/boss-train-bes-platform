package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;
import java.util.List;


@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    int deleteDictionaryByIds(@PathParam("ids") List<Long> ids);

}
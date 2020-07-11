package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CombExamItemMapper extends BaseMapper<CombExamItem> {

}
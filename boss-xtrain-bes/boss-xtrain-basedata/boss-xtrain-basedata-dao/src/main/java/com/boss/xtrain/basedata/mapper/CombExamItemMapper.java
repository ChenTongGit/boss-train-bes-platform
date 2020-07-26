package com.boss.xtrain.basedata.mapper;

import com.boss.xtrain.basedata.base.BaseMapper;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CombExamItemMapper extends BaseMapper<CombExamItem> {
    /**
     * 获取配置明细
     * @param combExamConfigId
     * @return
     */
    List<CombExamItem> getItemInfo(@Param("combExamConfigId") Long combExamConfigId);

    /**
     * 批量插入配置明细
     * @param itemList
     * @return
     */
    int insertBatch(@Param("itemList") List<CombExamItem> itemList);

    /**
     * 批量更新配置明细
     * @param itemList
     * @return
     */
    int updateBatch(@Param("itemList") List<CombExamItem> itemList);

}
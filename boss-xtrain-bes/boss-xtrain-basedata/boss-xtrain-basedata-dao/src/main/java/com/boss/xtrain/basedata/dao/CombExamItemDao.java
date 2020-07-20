package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;

import java.util.List;

public interface CombExamItemDao {
    /**
     * 增加配置明细
     * @param itemList
     * @return
     */
    int insertItem(List<CombExamItem> itemList);

    /**
     * 删除配置明细
     * @param c
     */
    void deleteItem(CombExamConfigDeleteDTO c);

    /**
     * 修改配置明细
     * @param itemList
     * @return
     */
    int updateItem(List<CombExamItem> itemList);

    /**
     * 批量删除配置明细
     * @param deleteItemIds
     */
    void deleteByIds(List<Long> deleteItemIds);

    /**
     * 批量删除配置明细
     * @param idList
     */
    void deleteByConfigIds(List<Long> idList);

    /**
     * 获取配置明细
     * @param c
     * @return
     */
    List<CombExamItemDTO>queryItemById(CombExamItemQueryDTO c);

}

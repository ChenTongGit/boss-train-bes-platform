package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CombExamItemDao;
import com.boss.xtrain.basedata.mapper.CombExamItemMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 组卷详情dao
 * @date 2020/07/08
 */
@Repository
@Slf4j
public class CombExamItemDaoImpl implements CombExamItemDao {

    @Autowired
    private CombExamItemMapper combExamItemMapper;

    @Override
    public int insertItem(List<CombExamItem> itemList) {
        return combExamItemMapper.insertBatch(itemList);
    }

    @Override
    public void deleteItem(CombExamConfigDeleteDTO c) {
        Example example = new Example(CombExamItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("combExamConfigId",c.getId());
        combExamItemMapper.deleteByExample(example);

    }

    @Override
    public int updateItem(List<CombExamItem> itemList) {
        return combExamItemMapper.updateBatch(itemList);
    }

    @Override
    public void deleteByIds(List<Long> deleteItemIds) {
        Example example = new Example(CombExamItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",deleteItemIds);
        combExamItemMapper.deleteByExample(example);
    }

    @Override
    public void deleteByConfigIds(List<Long> idList) {
        Example example = new Example(CombExamItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("combExamConfigId",idList);
        combExamItemMapper.deleteByExample(example);
    }

    @Override
    public List<CombExamItemDTO> queryItemById(CombExamItemQueryDTO c) {
        Long combExamConfigId = c.getId();
        List<CombExamItem> combExamConfigItems =  combExamItemMapper.getItemInfo(combExamConfigId);
        log.info(combExamConfigItems.toString());
        List<CombExamItemDTO> combExamItemDTOS = PojoUtils.copyListProperties(combExamConfigItems,CombExamItemDTO::new);
        log.info(combExamItemDTOS.toString());
        return combExamItemDTOS;

    }
}

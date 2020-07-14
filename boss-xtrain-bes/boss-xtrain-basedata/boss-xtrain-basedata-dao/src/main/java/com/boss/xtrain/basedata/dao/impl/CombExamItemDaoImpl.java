package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CombExamItemDao;
import com.boss.xtrain.basedata.mapper.CombExamItemMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CombExamItemDaoImpl implements CombExamItemDao {

    @Autowired
    private CombExamItemMapper combExamItemMapper;

    @Override
    public int insertItem(List<CombExamItem> itemList) {
        return combExamItemMapper.insertBatch(itemList);
    }

    @Override
    public void deleteItem(CombExamConfigDTO c) {
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
        List<CombExamItemDTO> combExamItemDTOS = new ArrayList<>();
        PojoUtils.copyProperties(combExamConfigItems,combExamItemDTOS);
        return combExamItemDTOS;

    }
}

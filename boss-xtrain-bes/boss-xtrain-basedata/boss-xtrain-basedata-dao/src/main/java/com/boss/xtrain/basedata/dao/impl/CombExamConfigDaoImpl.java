package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.CombExamConfigDao;
import com.boss.xtrain.basedata.mapper.CombExamConfigMapper;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamConfigQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 组卷dao
 * @date 2020/07/08
 */
@Repository
public class CombExamConfigDaoImpl implements CombExamConfigDao {

    @Autowired
    private CombExamConfigMapper combExamConfigMapper;

    @Override
    public int insertCombExamConfig(CombExamConfig combExamConfig) {
        combExamConfig.setStatus(1);
        return combExamConfigMapper.insert(combExamConfig);
    }

    @Override
    public int deleteCombExamConfig(Example example) {
        return combExamConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteCombExamConfigByIds(List<Long> idList) {
        Example example = new Example(CombExamConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",idList);
        return combExamConfigMapper.deleteByExample(example);
    }

    @Override
    public void updateCombExamConfig(CombExamConfig combExamConfig) {
        combExamConfigMapper.updateCombConfig(combExamConfig);
    }

    @Override
    public List<CombExamConfig> queryCombExamConfig(CombExamConfigQueryDTO combExamConfigQueryDTO) {
        Example example = new Example(CombExamConfig.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",combExamConfigQueryDTO.getOrgId());
        criteria.andLike("name","%"+combExamConfigQueryDTO.getName()+"%");
        return combExamConfigMapper.selectByExample(example);

    }

    /**
     * 因为name为空不支持模糊查询，所以删除了name
     * @param combExamConfigQueryDTO
     * @return
     */
    @Override
    public List<CombExamConfig> queryCombExamConfigTest(CombExamConfigQueryDTO combExamConfigQueryDTO) {
        Example example = new Example(CombExamConfig.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",combExamConfigQueryDTO.getOrgId());
        return combExamConfigMapper.selectByExample(example);
    }

    @Override
    public int checkRepeatName(Example example) {
        return combExamConfigMapper.selectCountByExample(example);
    }
}

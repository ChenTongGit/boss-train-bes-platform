package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.mapper.DictionaryMapper;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 字典dao
 * @date 2020/07/08
 */
@Slf4j
@Repository
public class DictionaryDaoImpl implements DictionaryDao {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public int insertDictionary(Dictionary dictionary) {
        dictionary.setStatus(1);
        return dictionaryMapper.insert(dictionary);
    }

    @Override
    public int insertDictionaryList(List<Dictionary> dictionaries) {
        for (Dictionary dictionary : dictionaries){
            dictionary.setStatus(1);
        }
        return dictionaryMapper.insertList(dictionaries);
    }

    @Override
    public int deleteDictionary(Example example) {
        return dictionaryMapper.deleteByExample(example);
    }

    @Override
    public int deleteDictionaryByIds(List<Long> ids) {
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return dictionaryMapper.deleteByExample(example);
    }

    @Override
    public int updateDictionary(Dictionary dictionary) {
        return dictionaryMapper.updateByPrimaryKey(dictionary);
    }

    @Override
    public List<DictionaryDTO> getDictionary() {
        List<Dictionary> dictionaries = dictionaryMapper.selectAll();
        return PojoUtils.copyListProperties(dictionaries, DictionaryDTO::new);
    }

    @Override
    public List<DictionaryDTO> queryDictionary(Example example) {
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
        return PojoUtils.copyListProperties(dictionaries,DictionaryDTO::new);
    }


    @Override
    public int checkRepeatName(Example example) {
        return dictionaryMapper.selectCountByExample(example);
    }


    @Override
    public boolean existId(Long id) {
        return dictionaryMapper.existsWithPrimaryKey(id);
    }

    @Override
    public List<DictionaryDTO> selectList(Example example) {
        return PojoUtils.copyListProperties(dictionaryMapper.selectByExample(example),DictionaryDTO::new);
    }

}

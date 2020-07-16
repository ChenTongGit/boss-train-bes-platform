package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.mapper.DictionaryMapper;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class DictionaryDaoImpl implements DictionaryDao {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public int insertDictionary(Dictionary dictionary) {
        return dictionaryMapper.insertUseGeneratedKeys(dictionary);
    }

    @Override
    public int insertDictionaryList(List<Dictionary> dictionaries) {
        return dictionaryMapper.insertList(dictionaries);
    }

    @Override
    public int deleteDictionary(Dictionary dictionary) {
        return dictionaryMapper.delete(dictionary);
    }

    @Override
    public int deleteDictionaryByIds(List<Long> ids) {
        return dictionaryMapper.deleteDictionaryByIds(ids);
    }

    @Override
    public int updateDictionary(Dictionary dictionary) {
        return dictionaryMapper.updateByPrimaryKey(dictionary);
    }

    @Override
    public List<DictionaryDTO> getDictionary() {
        List<Dictionary> dictionaries = dictionaryMapper.selectAll();
        List<DictionaryDTO> dictionaryDTOS = new ArrayList<>();
        PojoUtils.copyProperties(dictionaries, dictionaryDTOS);
        return dictionaryDTOS;
    }

    @Override
    public List<DictionaryDTO> queryDictionary(Dictionary dictionary) {
        List<Dictionary> dictionaries = dictionaryMapper.select(dictionary);
        List<DictionaryDTO> dictionaryDTOS = new ArrayList<>();
        PojoUtils.copyProperties(dictionaries,dictionaryDTOS);
        return dictionaryDTOS;
    }

    @Override
    public boolean existId(Long id) {
        return dictionaryMapper.existsWithPrimaryKey(id);
    }
}

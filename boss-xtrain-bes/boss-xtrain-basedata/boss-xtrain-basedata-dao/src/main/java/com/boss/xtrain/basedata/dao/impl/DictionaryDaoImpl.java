package com.boss.xtrain.basedata.dao.impl;

import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.mapper.DictionaryMapper;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class DictionaryDaoImpl implements DictionaryDao {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public int insertDictionary(Dictionary dictionary) {
        return dictionaryMapper.insert(dictionary);
    }

    @Override
    public int insertDictionaryList(List<Dictionary> dictionaries) {
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
        List<DictionaryDTO> dictionaryDTOS = PojoUtils.copyListProperties(dictionaries, DictionaryDTO::new);
        return dictionaryDTOS;
    }

    @Override
    public List<DictionaryDTO> queryDictionary(Example example) {
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
        List<DictionaryDTO> dictionaryDTOS = PojoUtils.copyListProperties(dictionaries,DictionaryDTO::new);
        return dictionaryDTOS;
    }

    @Override
    public boolean existId(Long id) {
        return dictionaryMapper.existsWithPrimaryKey(id);
    }

    @Override
    public List<DictionaryDTO> selectList(Example example) {
        List<DictionaryDTO> dictionaryDTOS=  PojoUtils.copyListProperties(dictionaryMapper.selectByExample(example),DictionaryDTO::new);
        log.info(dictionaryDTOS.toString());
        return dictionaryDTOS;
    }

    @Override
    public List<DifficultQueryDTO> queryCategory(Example example) {
        List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
        return PojoUtils.copyListProperties(dictionaries,DifficultQueryDTO::new);
    }

}

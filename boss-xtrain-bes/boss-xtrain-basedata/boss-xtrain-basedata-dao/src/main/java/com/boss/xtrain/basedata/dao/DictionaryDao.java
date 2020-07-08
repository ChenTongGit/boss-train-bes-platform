package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;

import java.util.List;


public interface DictionaryDao{

    int insertDictionary(Dictionary dictionary);

    int insertDictionaryList(List<Dictionary> dictionaries);

    int deleteDictionary(Dictionary dictionary);

    int deleteDictionaryByIds(List<Long> ids);

    int updateDictionary(Dictionary dictionary);

    List<DictionaryDTO> getDictionary();

    List<DictionaryDTO> queryDictionary(Dictionary dictionary);

}

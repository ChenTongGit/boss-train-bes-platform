package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.server.PathParam;
import java.util.List;


public interface DictionaryDao{

    int insertDictionary(@PathParam("dictionary") Dictionary dictionary);

    int insertDictionaryList(List<Dictionary> dictionaries);

    int deleteDictionary(Dictionary dictionary);

    int deleteDictionaryByIds(List<Long> ids);

    int updateDictionary(Dictionary dictionary);

    List<DictionaryDTO> getDictionary();

    List<DictionaryDTO> queryDictionary(Dictionary dictionary);

    boolean existId(Long id);

}

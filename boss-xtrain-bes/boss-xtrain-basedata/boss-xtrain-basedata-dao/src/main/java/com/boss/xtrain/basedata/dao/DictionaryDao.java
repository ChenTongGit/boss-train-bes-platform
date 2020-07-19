package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import org.apache.ibatis.cache.Cache;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.mapper.entity.Example;

import javax.websocket.server.PathParam;
import java.util.List;


public interface DictionaryDao{

    int insertDictionary(Dictionary dictionary);

    int insertDictionaryList(List<Dictionary> dictionaries);

    int deleteDictionary(Dictionary dictionary);

    int deleteDictionaryByIds(List<Long> ids);

    int updateDictionary(Dictionary dictionary);

    List<DictionaryDTO> getDictionary();

    List<DictionaryDTO> queryDictionary(Example example);

    boolean existId(Long id);

    List<DictionaryDTO> selectList(DictionaryDTO dictionaryDTO);

    List<DifficultQueryDTO> queryCategory(Example example);

}

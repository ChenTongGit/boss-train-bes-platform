package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryQueryDTO;

import java.util.List;

public interface DictionaryService{

    /**
     * 新增数据字典
     * @param dictionaryDTO
     * @return
     */
    DictionaryDTO insertDictionary(DictionaryDTO dictionaryDTO);

    /**
     * 批量增加数据字典
     * @param dictionaryDTOS
     */
    void insertDictionaryList(List<DictionaryDTO> dictionaryDTOS);

    /**
     * 根据数据字典id删除
     * @param dictionaryDTO
     */
    void deleteDictionary(DictionaryDTO dictionaryDTO);

    /**
     * 根据ids批量删除数据字典
     * @param dictionaryIdsDTO
     */
    void deleteDictionaryByIds(DictionaryIdsDTO dictionaryIdsDTO);

    /**
     * 更新数据字典
     * @param dictionaryDTO
     * @return
     */
    DictionaryDTO updateDictionary(DictionaryDTO dictionaryDTO);

    /**
     * 查询数据字典的全部信息
     * @return
     */
    List<DictionaryDTO> getDictionary();

    /**
     * 查询数据字典
     * @param dictionaryQueryDTO
     * @return
     */
    List<DictionaryDTO> queryDictionary(DictionaryQueryDTO dictionaryQueryDTO);

}

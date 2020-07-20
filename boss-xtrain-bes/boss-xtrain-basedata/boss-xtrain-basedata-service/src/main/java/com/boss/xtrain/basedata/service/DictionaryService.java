package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;

import java.util.List;

public interface DictionaryService{

    /**
     * 新增数据字典
     * @param dictionaryDTO
     * @return
     */
    int insertDictionary(DictionaryDTO dictionaryDTO);

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
     * @param dictionaryDTOS
     */
    int deleteDictionaryByIds(List<DictionaryDTO> dictionaryDTOS);

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

    /**
     *获取数据字典下拉表格数据
     * @param dictionaryDTO
     * @return
     */
    List<DictionaryDTO> selectList(DictionaryDTO dictionaryDTO);

    /**
     * 根据orgId获取category
     * @param difficultQueryDTO
     * @return
     */
    List<DifficultQueryDTO> queryCategory(DifficultQueryDTO difficultQueryDTO);

}

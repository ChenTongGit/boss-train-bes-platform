package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 字典dao
 * @date 2020/07/08
 */
public interface DictionaryDao{

    /**
     * 插入字典
     * @param dictionary
     * @return
     */
    int insertDictionary(Dictionary dictionary);

    /**
     * 批量插入字典，也就是导出
     * @param dictionaries
     * @return
     */
    int insertDictionaryList(List<Dictionary> dictionaries);

    /**
     * 删除一条字典信息
     * @param example
     * @return
     */
    int deleteDictionary(Example example);

    /**
     * 批量删除字典
     * @param ids
     * @return
     */
    int deleteDictionaryByIds(List<Long> ids);

    /**
     * 更新字典
     * @param dictionary
     * @return
     */
    int updateDictionary(Dictionary dictionary);

    /**
     * 查询全部字典
     * @return
     */
    List<DictionaryDTO> getDictionary();

    /**
     * 查询字典
     * @param example
     * @return
     */
    List<DictionaryDTO> queryDictionary(Example example);

    /**
     * 字典是否存在
     * @param id
     * @return
     */
    boolean existId(Long id);

    /**
     * 选择字典category列表
     * @param example
     * @return
     */
    List<DictionaryDTO> selectList(Example example);

    /**
     * 根据category查询
     * @param example
     * @return
     */
    List<DifficultQueryDTO> queryCategory(Example example);

}

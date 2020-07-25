package com.boss.xtrain.basedata.pojo.vo.dictionary;

import lombok.Data;

import java.util.List;

/**
 * @author gxr
 * @description DictionaryDeleteIdsVO
 * @date 2020/7/6
 */
@Data
public class DictionaryDeleteIdsVO {
    /**
     * 删除字典的信息列表的vo
     */
    List<DictionaryDeleteVO> ids;
}

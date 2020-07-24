package com.boss.xtrain.basedata.pojo.vo.dictionary;

import lombok.*;

/**
 * @author gxr
 * @description DictionaryInsertVO
 * @date 2020/7/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictionaryInsertVO {
    private Long id;
    private String name;
    private String category;
    private String value;
    private String remark;
    private Integer status;
    private Long version;

}

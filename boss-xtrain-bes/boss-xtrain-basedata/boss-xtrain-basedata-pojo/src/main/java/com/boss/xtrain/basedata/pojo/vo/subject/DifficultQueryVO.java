package com.boss.xtrain.basedata.pojo.vo.subject;

import lombok.Data;

/**
 * @author gxr
 * @description 难度查询VO
 * @date 2020/7/6
 */
@Data
public class DifficultQueryVO {
    /**
     * 组织id
     */
    private Long orgId;
    /**
     * 字典类别
     */
    private String category;
}

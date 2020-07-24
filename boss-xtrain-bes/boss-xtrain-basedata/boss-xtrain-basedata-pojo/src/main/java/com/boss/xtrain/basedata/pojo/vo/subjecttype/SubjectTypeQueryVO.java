package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import com.boss.xtrain.common.core.pojo.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gxr
 * @description 题目类别查询VO
 * @date 2020/7/6
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectTypeQueryVO extends BaseQuery {
    /**
     * 组织机构Id
     */
    private Long orgId;
    /**
     * 题型名称
     */
    private String name;
}

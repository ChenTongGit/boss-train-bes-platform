package com.boss.xtrain.basedata.pojo.vo.subjecttype;

import lombok.Data;

import java.util.List;

/**
 * @author gxr
 * @description 题目类别批量删除VO
 * @date 2020/7/6
 */
@Data
public class SubjectTypeDeleteIdsVO {
    /**
     * 批量删除的题型集合
     */
    private List<SubjectTypeDeleteVO> ids;
}

package com.boss.xtrain.basedata.pojo.vo.subject;

import lombok.Data;

import java.util.List;

/**
 * @author gxr
 * @description 题目批量删除VO
 * @date 2020/7/6
 */
@Data
public class SubjectDeleteIdsVO {
    /**
     * 批量删除的题目信息
     */
    private List<SubjectDeleteVO> ids;
}

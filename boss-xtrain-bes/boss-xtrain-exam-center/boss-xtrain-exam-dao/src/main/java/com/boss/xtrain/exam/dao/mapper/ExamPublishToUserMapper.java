package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.entity.ExamPublishToUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ExamPublishToUserMapper extends CommonMapper<ExamPublishToUser> {
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatchByPublishId(@Param("ids") List<Long> ids);

    /**
     * 批量添加
     * @param examPublishToUsers
     * @return
     */
    int insertBatch(@Param("examPublishToUsers") List<ExamPublishToUser> examPublishToUsers);

    /**
     * 通过publishId获取该场考试所有的阅卷官id列表
     * @param publishId
     * @return
     */
    List<Long> queryMarkUsersByPublishId(Long publishId);

}
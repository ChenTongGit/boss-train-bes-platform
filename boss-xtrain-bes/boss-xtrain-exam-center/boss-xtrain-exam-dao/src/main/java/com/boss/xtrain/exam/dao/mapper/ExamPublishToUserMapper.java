package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.entity.ExamPublishToUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ExamPublishToUserMapper extends CommonMapper<ExamPublishToUser> {
    int deleteBatchByPublishId(@Param("ids") List<Long> ids);

    int insertBatch(@Param("examPublishToUsers") List<ExamPublishToUser> examPublishToUsers);

}
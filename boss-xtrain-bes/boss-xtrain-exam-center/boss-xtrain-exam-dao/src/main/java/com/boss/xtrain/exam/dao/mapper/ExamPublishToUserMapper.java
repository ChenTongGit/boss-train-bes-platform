package com.boss.xtrain.exam.dao.mapper;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.exam.pojo.entity.ExamPublishToUser;

import java.util.List;


public interface ExamPublishToUserMapper extends CommonMapper<ExamPublishToUser> {
    int deleteBatchByPublishId(List<Long> ids);

}
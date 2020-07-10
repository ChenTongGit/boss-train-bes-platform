package com.boss.xtrain.exam.dao.impl;

import com.boss.xtrain.exam.dao.ExamPublishToUserDao;
import com.boss.xtrain.exam.dao.mapper.ExamPublishToUserMapper;
import com.boss.xtrain.exam.pojo.entity.ExamPublishToUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 阅卷关系表dao实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 10:34
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Repository
@Slf4j
public class ExamPublishToUserDaoImpl implements ExamPublishToUserDao {
    @Resource
    private ExamPublishToUserMapper examPublishToUserMapper;


    /**
     * 批量添加关系
     * AOP自动注入公共片段
     * @param examPublishToUsers 关系列表
     * @return int
     * @author ChenTong
     * @date 2020/7/9 10:30
     */
    @Override
    public int insertBatch(List<ExamPublishToUser> examPublishToUsers) {
        return examPublishToUserMapper.insertBatch(examPublishToUsers);
    }

    /**
     * 批量删除关系
     * @param ids 考试发布id
     * @return int
     * @author ChenTong
     * @date 2020/7/9 10:30
     */
    @Override
    public int deleteBatchByPublishId(List<Long> ids) {

        return examPublishToUserMapper.deleteBatchByPublishId(ids);
    }

    /**
     * 通过发布id获取该发布记录下的所有阅卷官关系表
     *
     * @param examPublishToUser 发布记录ID
     * @return com.boss.xtrain.exam.pojo.entity.ExamPublishToUser
     * @author ChenTong
     * @date 2020/7/9 10:31
     */
    @Override
    public List<ExamPublishToUser> query(ExamPublishToUser examPublishToUser) {
        return examPublishToUserMapper.select(examPublishToUser);
    }
}

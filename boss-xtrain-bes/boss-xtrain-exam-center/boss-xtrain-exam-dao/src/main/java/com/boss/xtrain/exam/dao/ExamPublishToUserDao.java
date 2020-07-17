package com.boss.xtrain.exam.dao;

import com.boss.xtrain.exam.pojo.entity.ExamPublishToUser;

import java.util.List;

/**
 * 阅卷关系表
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 10:27
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamPublishToUserDao {
    /**
     * 批量添加关系
     * @author ChenTong
     * @param examPublishToUsers
     * @return int
     * @date 2020/7/9 10:30
     */
    int insertBatch(List<ExamPublishToUser> examPublishToUsers);

    /**
     * 批量删除关系
     * @author ChenTong
     * @param publishID
     * @return int
     * @date 2020/7/9 10:30
     */
    int deleteBatchByPublishId(Long publishID);

    int deleteBatchByPublishIds(List<Long> ids);

    /**
     * 通过发布id获取该发布记录下的所有阅卷官关系表
     * @author ChenTong
     * @param examPublishToUser 发布记录ID
     * @return com.boss.xtrain.exam.pojo.entity.ExamPublishToUser
     * @date 2020/7/9 10:31
     */
    List<ExamPublishToUser> query(ExamPublishToUser examPublishToUser);

    /**
     * 通过发布试卷记录id获取该场考试的阅卷官
     * @author ChenTong
     * @param publishId
     * @return java.util.List<java.lang.Long>
     * @date 2020/7/10 18:12
     */
    List<Long> queryMarkUserByPublishId(Long publishId);

}

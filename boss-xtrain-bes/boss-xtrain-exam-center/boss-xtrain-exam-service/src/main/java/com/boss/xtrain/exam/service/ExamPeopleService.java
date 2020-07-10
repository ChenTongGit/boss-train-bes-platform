package com.boss.xtrain.exam.service;

import com.boss.xtrain.exam.pojo.dto.ExamPeopleRegisterDTO;

/**
 * 考生服务
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 0:07
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamPeopleService {

    /**
     * 注册
     * @author ChenTong
     * @param dto
     * @return java.lang.Integer
     * @date 2020/7/10 0:18
     */
    Integer register(ExamPeopleRegisterDTO dto);
}

package com.boss.xtrain.exam.service;

import com.boss.xtrain.exam.pojo.dto.ExamPeopleInfoDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePasswordLoginDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePhotoDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeopleRegisterDTO;

import java.util.Base64;

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

    /**
     * 考生通过账号密码登录
     * @author ChenTong
     * @param dto
     * @return com.boss.xtrain.exam.pojo.dto.ExamPeopleInfoDTO
     * @date 2020/7/10 10:03
     */
    ExamPeopleInfoDTO loginWithPsw(ExamPeoplePasswordLoginDTO dto);

    /**
     * 手机登录
     * @author ChenTong
     * @param mobile
     * @return com.boss.xtrain.exam.pojo.dto.ExamPeopleInfoDTO
     * @date 2020/7/10 10:03
     */
    ExamPeopleInfoDTO loginWithMsg(String mobile);

    /**
     * 图片上传
     * @author ChenTong
     * @param peoplePhotoDTO 
     * @return java.lang.String
     * @date 2020/7/10 17:36
     */
    String uploadImg(ExamPeoplePhotoDTO peoplePhotoDTO);


}

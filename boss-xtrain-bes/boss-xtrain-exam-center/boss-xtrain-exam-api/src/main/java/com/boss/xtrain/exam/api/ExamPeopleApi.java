package com.boss.xtrain.exam.api;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePasswordLoginDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePhotoDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeopleRegisterDTO;
import com.boss.xtrain.exam.pojo.vo.ExamPeopleInfoVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 考试人员相关接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 22:23
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamPeopleApi {

    /**
     * 考生注册
     * @author ChenTong
     * @param request 封装请求
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @date 2020/7/9 23:35
     */
    @PostMapping("/newExamPeople")
    CommonResponse<Integer> examRegister(@RequestBody @Valid CommonRequest<ExamPeopleRegisterDTO> request);

    /**
     * 上传照片
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer> 返回url
     * @date 2020/7/10 0:23
     */
    @PostMapping("/photo")
    CommonResponse<String> uploadPhoto(@RequestBody @Valid CommonRequest<ExamPeoplePhotoDTO> request);

    /**
     * 通过账号密码登录
     * @author ChenTong
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.exam.pojo.vo.ExamPeopleInfoVO>
     * @date 2020/7/10 10:49
     */
    @PostMapping("/pswLogin")
    CommonResponse<ExamPeopleInfoVO> loginWithPsw(@RequestBody @Valid CommonRequest<ExamPeoplePasswordLoginDTO> request);

    /**
     * 通过手机号登录
     * @author ChenTong
     * @param mobile 
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.exam.pojo.vo.ExamPeopleInfoVO>
     * @date 2020/7/10 10:49
     */
    @PostMapping("/msgLogin")
    CommonResponse<ExamPeopleInfoVO> loginWithMsg(@RequestBody @Valid CommonRequest<String> mobile);
}

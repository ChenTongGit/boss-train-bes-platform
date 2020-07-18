package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.api.ExamPeopleApi;
import com.boss.xtrain.exam.pojo.dto.ExamPeopleInfoDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePasswordLoginDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePhotoDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeopleRegisterDTO;
import com.boss.xtrain.exam.pojo.vo.ExamPeopleInfoVO;
import com.boss.xtrain.exam.service.ExamPeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 考试人员逻辑控制器
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/12 22:39
 * @copyright
 * @modified
 * @see
 * @since
 **/
@RestController
@RequestMapping(CommonConstant.BASIC_URL+"/exam/people")
@Api(value = "手机答卷考生Controller" , tags = {"考生登录注册"})
public class ExamPeopleController extends BaseController implements ExamPeopleApi {

    @Autowired
    private ExamPeopleService examPeopleService;

    /**
     * 考生注册
     * @param request 封装请求
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer>
     * @author ChenTong
     * @date 2020/7/9 23:35
     */
    @ApiLog(msg = "考生注册")
    @ApiOperation(value = "考生注册")
    @Override
    public CommonResponse<Integer> examRegister(@Valid CommonRequest<ExamPeopleRegisterDTO> request) {
        return CommonResponseUtil.ok(examPeopleService.register(request.getBody()));
    }


    /**
     * 上传照片 后端返回照片url
     * @param request
     * @return com.boss.xtrain.common.core.http.CommonResponse<java.lang.Integer> 返回url
     * @author ChenTong
     * @date 2020/7/10 0:23
     */
    @ApiLog(msg = "考生上传照片->oos")
    @ApiOperation(value = "考生上传照片")
    @Override
    public CommonResponse<String> uploadPhoto(@Valid CommonRequest<ExamPeoplePhotoDTO> request) {
        return null;
    }

    @ApiLog(msg = "考生登录 -  手机密码")
    @ApiOperation(value = "考生通过账号密码登录")
    @Override
    public CommonResponse<ExamPeopleInfoVO> loginWithPsw(@Valid CommonRequest<ExamPeoplePasswordLoginDTO> request) {
        // 考生登录并获取考生信息
        ExamPeopleInfoDTO examPeopleInfoDTO = this.examPeopleService.loginWithPsw(request.getBody());
        // 数据转换
        ExamPeopleInfoVO vo = new ExamPeopleInfoVO();

        PojoUtils.copyProperties(examPeopleInfoDTO, vo);

        return CommonResponseUtil.ok(vo);
    }

    /**
     * 通过手机号登录
     *
     * @param mobile
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.exam.pojo.vo.ExamPeopleInfoVO>
     * @author ChenTong
     * @date 2020/7/10 10:47
     */
    @ApiLog(msg = "考生登录 -  手机验证码")
    @ApiOperation(value = "考生通过手机验证码登录")
    @Override
    public CommonResponse<ExamPeopleInfoVO> loginWithMsg(@Valid CommonRequest<String> mobile) {
        // 考生登录并获取考生信息
        ExamPeopleInfoDTO examPeopleInfoDTO = this.examPeopleService.loginWithMsg(mobile.getBody());
        // 数据转换
        ExamPeopleInfoVO vo = new ExamPeopleInfoVO();

        PojoUtils.copyProperties(examPeopleInfoDTO, vo);

        return CommonResponseUtil.ok(vo);
    }


}

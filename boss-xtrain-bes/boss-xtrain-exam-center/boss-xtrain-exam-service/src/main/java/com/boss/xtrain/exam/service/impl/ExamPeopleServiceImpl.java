package com.boss.xtrain.exam.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.common.util.SmsTools;
import com.boss.xtrain.common.util.oss.OssUtils;
import com.boss.xtrain.exam.dao.ExamPeopleDao;
import com.boss.xtrain.exam.pojo.dto.ExamPeopleInfoDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePasswordLoginDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeoplePhotoDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPeopleRegisterDTO;
import com.boss.xtrain.exam.pojo.entity.ExamPeople;
import com.boss.xtrain.exam.service.ExamPeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 考生服务实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/12 0:08
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamPeopleServiceImpl implements ExamPeopleService {

    @Autowired
    private ExamPeopleDao examPeopleDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 注册
     * @author ChenTong
     * @param dto
     * @return java.lang.Integer
     * @date 2020/7/10 0:17
     */
    @Override
    public Integer register(ExamPeopleRegisterDTO dto) {
        if (null == dto)
            throw new BusinessException(BusinessError.EXAM_PEOPLE_REG_FAIL);
        try {
            // 转换dto=》entity
            ExamPeople entity = new ExamPeople();
            PojoUtils.copyProperties(dto, entity);
            // 雪花算法生成id
            entity.setId(idWorker.nextId());
            return this.examPeopleDao.insert(entity);
        }catch (Exception e){
            log.error(BusinessError.EXAM_PEOPLE_REG_FAIL.getMessage(),e);
            throw new BusinessException(BusinessError.EXAM_PEOPLE_REG_FAIL, e);
        }
    }

    /**
     * 考生通过账号密码登录
     *
     * @param dto
     * @return com.boss.xtrain.exam.pojo.dto.ExamPeopleInfoDTO
     * @author ChenTong
     * @date 2020/7/10 10:03
     */
    @Override
    public ExamPeopleInfoDTO loginWithPsw(ExamPeoplePasswordLoginDTO dto) {

        ExamPeople examPeople = new ExamPeople();
        examPeople.setMobile(dto.getMobile());
        // 通过账号查询调用数据库查询基本的
        ExamPeople curLoginUser = this.examPeopleDao.queryForOne(examPeople);
        if (null == curLoginUser)
            // 考生不存在
            throw new BusinessException(BusinessError.EXAM_PEOPLE_NOT_EXIT);
        // 判断账号密码是否正确
        if (!curLoginUser.getPassword().equals(dto.getPassword()))
            // 登录失败
            throw new BusinessException(BusinessError.EXAM_PEOPLE_LOGIN_WITH_PASSWORD_FAIL);
        // 返回数据
        ExamPeopleInfoDTO examPeopleInfoDTO = new ExamPeopleInfoDTO();
        PojoUtils.copyProperties(curLoginUser, examPeopleInfoDTO);
        return examPeopleInfoDTO;
    }

    /**
     * 手机登录
     *
     * @param mobile
     * @return com.boss.xtrain.exam.pojo.dto.ExamPeopleInfoDTO
     * @author ChenTong
     * @date 2020/7/10 10:03
     */
    @Override
    public ExamPeopleInfoDTO loginWithMsg(String mobile) {
        ExamPeople examPeople = new ExamPeople();
        examPeople.setMobile(mobile);
        // 通过账号查询调用数据库查询基本的
        ExamPeople curLoginUser = this.examPeopleDao.queryForOne(examPeople);
        if (null == curLoginUser){
            throw new BusinessException(BusinessError.EXAM_PEOPLE_NOT_EXIT);
        }
        // 用户存在 发送短信验证码进行登录
        ExamPeopleInfoDTO dto = new ExamPeopleInfoDTO();
        PojoUtils.copyProperties(curLoginUser, dto);
        try {
            // 发送手机验证码
            SendSmsResponse response = SmsTools.sendSmsWithTemplateCode(mobile);
            // 返回前端做匹配使用
            dto.setVerificationCode(response.getCode());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_PEOPLE_LOGIN_WITH_MSG_SEND_SSM_FAIL);
        }
        return dto;
    }

    /**
     * 图片上传
     *
     * @param peoplePhotoDTO
     * @return java.lang.String 图片的url
     * @author ChenTong
     * @date 2020/7/10 17:34
     */
    @Override
    public String uploadImg(ExamPeoplePhotoDTO peoplePhotoDTO) {
        return null;
    }
}

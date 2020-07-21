package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.service.SystemFeign;
import com.boss.xtrain.permission.pojo.dto.ExamServiceUsersDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ChenTong
 * @date 2020/7/20 13:10
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Slf4j
@Component
public class SystemFallBack implements SystemFeign {

    /**
     * 通过position信息查找user
     *
     * @param request
     * @return List<UserDTO>
     */
    @Override
    public CommonResponse<List<ExamServiceUsersDTO>> getUserByPosition(@Valid CommonRequest<UserQueryDTO> request) {
        log.error("获取考试阅卷人失败");
        throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_GET_MARK_PEOPLE_ERR);
    }
}

package com.boss.xtrain.exam.service;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.exam.service.impl.SystemFallBack;
import com.boss.xtrain.permission.pojo.dto.ExamServiceUsersDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 系统服务调用
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/20 13:04
 * @copyright
 * @modified
 * @see
 * @since
 **/
@FeignClient(name = "boss-bes-system", fallback = SystemFallBack.class)
@Component
public interface SystemFeign {

    /**
     * 通过position信息查找user
     * @param request
     * @return  List<UserDTO>
     */
    @PostMapping("/education/bes/v1/user/getUserByPosition")
    CommonResponse<List<ExamServiceUsersDTO>> getUserByPosition(@RequestBody @Valid CommonRequest<UserQueryDTO> request);
}

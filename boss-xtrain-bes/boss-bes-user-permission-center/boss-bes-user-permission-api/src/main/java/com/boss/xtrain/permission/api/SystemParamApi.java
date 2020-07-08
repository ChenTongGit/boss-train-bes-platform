package com.boss.xtrain.permission.api;

import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.permission.pojo.vo.SystemParamVO;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 53534 秦昀清
 * @date 2020.07.07
 */
@RequestMapping("/education/bes/v1/systemParam")
public interface SystemParamApi extends CommonCRUDApi<SystemParamDTO, SystemParamQuery, SystemParamVO> {

}

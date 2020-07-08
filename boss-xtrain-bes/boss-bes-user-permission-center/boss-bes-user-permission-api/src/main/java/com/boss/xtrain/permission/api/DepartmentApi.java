package com.boss.xtrain.permission.api;

import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.vo.DepartmentVO;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534 秦昀清
 * @date 2020.07.07
 */
public interface DepartmentApi extends CommonCRUDApi<DepartmentDTO, DepartmentQuery, DepartmentVO> {
    /**
     * 查树
     * @param request request
     * @return
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    CommonResponse<List<DepartmentVO>> selectTree(@RequestBody @Valid CommonRequest<DepartmentQuery> request);
}

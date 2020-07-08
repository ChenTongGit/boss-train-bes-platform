package com.boss.xtrain.permission.api;

import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.vo.DepartmentVO;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534 秦昀清
 * @date 2020.07.07
 */
@RequestMapping("/education/bes/v1/department")
public interface DepartmentApi extends CommonCRUDApi<DepartmentDTO, DepartmentQuery, DepartmentVO> {
    /**
     * 查树
     * @param request request
     * @return
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @PostMapping("/tree")
    CommonResponse<List<DepartmentVO>> selectTree(@RequestBody @Valid CommonRequest<DepartmentQuery> request);
}

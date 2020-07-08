package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
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
    CommonResponse<List<DepartmentQuery>> selectTree(@RequestBody @Valid CommonRequest<DepartmentQuery> request);

    /**
     * 初始化所有
     * @param request request
     * @return
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @PostMapping("/originAll")
    CommonResponse<List<DepartmentVO>> selectAll(@RequestBody @Valid CommonRequest<DepartmentQuery> request);

    /**
     * 分页条件搜索
     * @param request
     * @return
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<DepartmentVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<DepartmentQuery>> request);

}

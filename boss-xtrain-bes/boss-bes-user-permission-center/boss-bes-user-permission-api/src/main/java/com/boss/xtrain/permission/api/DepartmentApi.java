package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.query.CompanyDepartmentNode;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.vo.DepartmentVO;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.GetMapping;
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
     * 查树的公司
     * @return 查询到所有的公司
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @GetMapping("/tree")
    CommonResponse<List<CompanyQuery>> selectTree();

    /**
     * 查树的部门
     * @param request 带有条件的查树
     * @return 部门树
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @PostMapping("/treeDepartment")
    CommonResponse<List<CompanyDepartmentNode>> selectDepartmentTree(@RequestBody @Valid CommonRequest<CompanyQuery> request);

    /**
     * 所有分页
     * @param request 分页条件
     * @return 查到的登录人负责的组织机构下部门
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @PostMapping("/AllByPage")
    CommonResponse<CommonPage<DepartmentVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest> request);

    @PostMapping("/selectByKey")
    CommonResponse<DepartmentVO> selectByPrimaryKey(@RequestBody @Valid CommonRequest<DepartmentQuery> request);

    /**
     * 初始化所有不分页
     * @return 所有部门列表
     */
    @GetMapping("/selectAll")
    CommonResponse<List<DepartmentVO>> selectAll();

    /**
     * 分页条件搜索，包括初始化
     * @param request 条件分页
     * @return 点击树得到相应的组织机构下，公司或上级部门下的部门列表
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<DepartmentVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<DepartmentQuery>> request);
}

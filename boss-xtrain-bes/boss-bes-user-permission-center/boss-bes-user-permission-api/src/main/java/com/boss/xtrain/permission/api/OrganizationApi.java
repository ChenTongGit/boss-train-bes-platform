<<<<<<< HEAD
package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.vo.OrganizationVO;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 * -->2020.07.08
 */
@RequestMapping("/education/bes/v1/organization")
public interface OrganizationApi extends CommonCRUDApi<OrganizationDTO, OrganizationQuery, OrganizationVO> {
    /**
     * 查所有
     * @return
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */

    @GetMapping("/selectAll")
    CommonResponse<List<OrganizationVO>> selectAllOrg();

    @PostMapping("/selectByKey")
    CommonResponse<OrganizationVO> selectByPrimaryKey(@RequestBody @Valid CommonRequest<OrganizationQuery> request);

    /**
     * 分页条件搜索
     * @param request
     * @return
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<OrganizationVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<OrganizationQuery>> request);

    /**
     * 分页全搜索
     * @param request
     * @return
     */
    @PostMapping("/allByPage")
    CommonResponse<CommonPage<OrganizationVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest> request);
}
=======
package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.vo.OrganizationVO;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 * -->2020.07.08
 */
@RequestMapping("/education/bes/v1/organization")
public interface OrganizationApi extends CommonCRUDApi<OrganizationDTO, OrganizationQuery, OrganizationVO> {
    /**
     * 查所有
     * @return
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */

    @GetMapping("/selectAll")
    CommonResponse<List<OrganizationVO>> selectAllOrg();

    /**
     * 分页条件搜索
     * @param request
     * @return
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<OrganizationVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<OrganizationQuery>> request);

    /**
     * 分页全搜索
     * @param request
     * @return
     */
    @PostMapping("/allByPage")
    CommonResponse<CommonPage<OrganizationVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest> request);
}
>>>>>>> ysq-dev

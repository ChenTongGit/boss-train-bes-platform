package com.boss.xtrain.permission.api;

import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.vo.CompanyVO;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 53534 秦昀清
 * @date 2020.07.07
 */
@RequestMapping("/education/bes/v1/company")
public interface CompanyApi extends CommonCRUDApi<CompanyDTO, CompanyQuery, CompanyVO> {

    /**
     * 查所有
     * @return
     * RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    CommonResponse<List<CompanyVO>> selectAllCompany();
}

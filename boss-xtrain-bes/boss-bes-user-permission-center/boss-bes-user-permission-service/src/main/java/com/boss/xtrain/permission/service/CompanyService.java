package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.common.core.web.service.CommonCurdService;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
public interface CompanyService extends CommonCurdService<CompanyDTO, CompanyQuery> {

    /**
     * 搜索一个
     * @param query query
     * @return
     */
    CompanyDTO selectOne(CompanyQuery query);

    /**
     * 获得所有的org以供添加公司时选择
     * @return
     */
    List<OrganizationQuery> listAllOrg();

    /**
     * 组织机构下所有
     * @param query q
     * @return
     */
    List<CompanyDTO> selectOrgCompanyAll(CompanyQuery query);
}

package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.common.core.web.service.CommonCurdService;


/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
public interface OrganizationService extends CommonCurdService<OrganizationDTO, OrganizationQuery> {

    OrganizationDTO selectByPrimaryKey(OrganizationQuery query);

    /**
     * 只查一个
     * @param query query
     * @return
     */
    OrganizationDTO selectOne(OrganizationQuery query);
}

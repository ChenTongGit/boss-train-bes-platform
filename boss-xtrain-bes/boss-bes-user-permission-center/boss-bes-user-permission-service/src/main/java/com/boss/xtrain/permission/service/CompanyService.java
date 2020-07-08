package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.common.core.web.service.CommonCurdService;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
public interface CompanyService extends CommonCurdService<CompanyDTO, CompanyQuery> {
    /**
     * 查询所有
     * @return
     */
    List<CompanyDTO> selectAll();

    /**
     * 搜索一个
     * @param query query
     * @return
     */
    CompanyDTO selectOne(CompanyQuery query);
}
